package com.solify.server.service;

import com.solify.server.Configuration.CalibConfig;
import com.solify.server.Constants.WmsResponseKeys;
import com.solify.server.client.WmsClient;
import com.solify.server.controller.response.SolinstralningResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class WmsServiceTest {

    @InjectMocks
    WmsService wmsService;

    @Mock
    WmsClient wmsClient;

    @Mock
    CalibConfig calibConfig;

    @Before
    public void setup() {
        when(wmsClient.getSoldata(anyDouble(), anyDouble(), anyDouble(), anyDouble())).thenReturn(createResponse());
        when(calibConfig.getPerc_of_roof_area()).thenReturn(70);
        when(calibConfig.getSolarcellmodule_area()).thenReturn(1.64);
        when(calibConfig.getModule_price()).thenReturn(2125);
        when(calibConfig.getElecComp_price()).thenReturn(3000);
        when(calibConfig.getArmature_price()).thenReturn(3000);
        when(calibConfig.getAssembly_price()).thenReturn(10000);
        when(calibConfig.getEl_price()).thenReturn(0.35);
        when(calibConfig.getCertificate()).thenReturn(0.10);
        when(calibConfig.getTaxredux()).thenReturn(0.60);
        when(calibConfig.getMaintainace_cost()).thenReturn(0.0);
        when(calibConfig.getGridbenefit()).thenReturn(0.05);
        when(calibConfig.getLifelength()).thenReturn(30);
        when(calibConfig.getBbox_lng_add()).thenReturn(0.00001);
        when(calibConfig.getBbox_lat_add()).thenReturn(0.00001);
    }

    @Test
    public void test__fetchWmsData__success() {
        SolinstralningResponse response = wmsService.fetchWmsData(0.001, 0.0001);
        assertEquals(3451, response.getSys_size().intValue());
        assertEquals(14, response.getNbr_of_modules().intValue());
        assertEquals(45750, response.getTot_price().intValue());
        assertEquals(13725, response.getSubsidy().intValue());
        assertEquals(113882, response.getTot_earnings().intValue());
        assertEquals(81857, response.getProfit().intValue());
    }

    private HashMap<String, Integer> createResponse() {
        HashMap<String, Integer> responseMap = new HashMap<String, Integer>();
        responseMap.put(WmsResponseKeys.TAKYTA_1000, 34);
        responseMap.put(WmsResponseKeys.TAK_950_10, 2);
        responseMap.put(WmsResponseKeys.SOL_1000, 4930);
        responseMap.put(WmsResponseKeys.SOL_950_10, 281);
        return responseMap;
    }
}