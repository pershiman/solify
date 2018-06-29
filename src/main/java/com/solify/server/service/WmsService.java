package com.solify.server.service;

import com.solify.server.client.WmsClient;
import com.solify.server.controller.response.SolinstralningResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WmsService {
    public static Logger logger = LogManager.getLogger();

    @Autowired
    WmsClient wmsClient;

    public SolinstralningResponse fetchWmsData(Double longitude, Double latitude) {
        logger.info("=========== Entering wmsService process ============");
        SolinstralningResponse solinstralningResponse = wmsClient.getSoldata(longitude, latitude);
        return solinstralningResponse;
    }
}
