package com.solify.server.service;

import com.solify.server.Constants.CalibConstants;
import com.solify.server.Constants.WmsResponseKeys;
import com.solify.server.Configuration.CalibConfig;
import com.solify.server.client.WmsClient;
import com.solify.server.controller.response.SolinstralningResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

@Service
public class WmsService {
    public static Logger logger = LogManager.getLogger();

    @Autowired
    WmsClient wmsClient;

    @Autowired
    CalibConfig calibConfig;

    public SolinstralningResponse fetchWmsData(double longitude, double latitude) {
        logger.info("=========== Entering wmsService process ============");
        HashMap<String, Integer> responseMap = wmsClient.getSoldata(longitude, latitude,
                calibConfig.getBbox_lng_add(), calibConfig.getBbox_lat_add());
        SolinstralningResponse solinstralningResponse = createResult(responseMap);
        return solinstralningResponse;
    }

    private SolinstralningResponse createResult(HashMap<String, Integer> responseMap) {

        SolinstralningResponse solinstralningResponse =new SolinstralningResponse();

        int sys_size = setSysSize(responseMap, solinstralningResponse);
        int numOfModules = setNumOfModules(responseMap, solinstralningResponse);
        int tot_price = setPrice(numOfModules, solinstralningResponse);
        int subsidy = setSubsidy(tot_price, solinstralningResponse);
        int total_earnings = setEarnings(sys_size, solinstralningResponse);
        setEnvironmentWin(sys_size, solinstralningResponse);
        setProfit(total_earnings, tot_price, subsidy, solinstralningResponse);
        solinstralningResponse.setTakyta(responseMap.get(WmsResponseKeys.TAKYTA));
        solinstralningResponse.setTak_1000(responseMap.get(WmsResponseKeys.TAKYTA_1000));
        solinstralningResponse.setTak_950_10(responseMap.get(WmsResponseKeys.TAK_950_10));
        solinstralningResponse.setSol_1000(responseMap.get(WmsResponseKeys.SOL_1000));
        solinstralningResponse.setSol_950_10(responseMap.get(WmsResponseKeys.SOL_950_10));
        return solinstralningResponse;
    }

    private void setProfit(int total_earnings, int tot_price, int subsidy, SolinstralningResponse solinstralningResponse) {
        solinstralningResponse.setProfit(total_earnings - (tot_price - subsidy));
    }

    private int setSysSize(HashMap<String, Integer> responseMap, SolinstralningResponse solinstralningResponse) {
        double wat_1000 = 0;
        double wat_950_10 = 0;
        if(responseMap.get(WmsResponseKeys.TAKYTA_1000) > CalibConstants.MIN_ROOF_AREA) {
            wat_1000 = responseMap.get(WmsResponseKeys.SOL_1000) * responseMap.get(WmsResponseKeys.TAKYTA_1000) * calibConfig.getPerc_of_roof_area() * calibConfig.getSolarcellmodule_efficiency();
        }
        if(responseMap.get(WmsResponseKeys.TAK_950_10) > CalibConstants.MIN_ROOF_AREA) {
            wat_950_10 = responseMap.get(WmsResponseKeys.SOL_950_10) * responseMap.get(WmsResponseKeys.TAK_950_10) * calibConfig.getPerc_of_roof_area() * calibConfig.getSolarcellmodule_efficiency();
        }
        int sys_size = (int) (wat_1000 + wat_950_10) / 100;
        solinstralningResponse.setSys_size(sys_size);
        return sys_size;
    }

    private int setSubsidy(int tot_price, SolinstralningResponse solinstralningResponse) {
        double subsidy = (double) tot_price * CalibConstants.SOLAR_CELL_SUBSIDY;
        solinstralningResponse.setSubsidy((int) subsidy);
        return (int)subsidy;
    }

    private int setPrice(int numOfModules, SolinstralningResponse solinstralningResponse) {
        int tot_price = numOfModules * calibConfig.getModule_price() + calibConfig.getArmature_price()
                + calibConfig.getAssembly_price() + calibConfig.getElecComp_price();
        solinstralningResponse.setTot_price(tot_price);
        return tot_price;
    }

    private int setNumOfModules(HashMap<String, Integer> responseMap, SolinstralningResponse solinstralningResponse) {
        double modules_1000 = 0;
        double modules_950_10 = 0;
        int area_1000 = responseMap.get(WmsResponseKeys.TAKYTA_1000);
        int area_950_10 = responseMap.get(WmsResponseKeys.TAK_950_10);
        if(area_1000 > CalibConstants.MIN_ROOF_AREA) {
            modules_1000 = (double) area_1000 * calibConfig.getPerc_of_roof_area() / (calibConfig.getSolarcellmodule_area() * 100);
        }
        if(area_950_10 > CalibConstants.MIN_ROOF_AREA) {
            modules_950_10 = area_950_10 * calibConfig.getPerc_of_roof_area() / (calibConfig.getSolarcellmodule_area() * 100);
        }
        int numOfModules = (int) (modules_950_10 + modules_1000);
        solinstralningResponse.setNbr_of_modules(numOfModules);
        return numOfModules;
    }

    private int setEarnings(int sys_size, SolinstralningResponse solinstralningResponse) {
        int tot_earnings = (int) (sys_size * (calibConfig.getEl_price() + calibConfig.getCertificate()
                + calibConfig.getTaxredux() + calibConfig.getMaintainace_cost()
                + calibConfig.getGridbenefit()) * calibConfig.getLifelength());
        solinstralningResponse.setTot_earnings(tot_earnings);

        return tot_earnings;
    }
    // TODO
    private void setEnvironmentWin(int sys_size, SolinstralningResponse solinstralningResponse) {
        int tot_EnvironmentWin = 0;
        double gasEmission = sys_size * 0.1 / (CalibConstants.EMISSION_GALLON / CalibConstants.GALLON_TO_LITRE);

    }
}
