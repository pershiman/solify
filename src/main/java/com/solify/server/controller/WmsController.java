package com.solify.server.controller;


import com.solify.server.controller.request.SolinstralningRequest;
import com.solify.server.controller.response.SolinstralningResponse;
import com.solify.server.service.WmsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value = "/wms")
public class WmsController {
    public static Logger logger = LogManager.getLogger();

    @Autowired
    private WmsService wmsService;

    @RequestMapping(value="/solinstralning", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<SolinstralningResponse> getSoldata(@RequestParam Double longitude, @RequestParam Double latitude) {
        logger.info("=========== Initiating solinstralning process ============");

        SolinstralningResponse solinstralningResponse = wmsService.fetchWmsData(longitude, latitude);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        headers.add("Access-Control-Allow-Origin", "*");

        return  ResponseEntity.ok()
                    .headers(headers)
                    .body(solinstralningResponse);
    }

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity test() {
        logger.info("=========== Initiating test process ============");
        return ResponseEntity.ok("Test ok");
    }
}
