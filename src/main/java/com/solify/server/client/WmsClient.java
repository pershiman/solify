package com.solify.server.client;

import com.solify.server.controller.response.SolinstralningResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class WmsClient {
    public static Logger logger = LogManager.getLogger();

    private static String byggLayers = "layers=mftemp:solinstralning-2012-byggnader&";
    private static String reqType = "request=GetFeatureInfo&";
    private static String coord = "CRS=CRS:84&";
    private static String queryByggLayers = "QUERY_LAYERS=mftemp:solinstralning-2012-byggnader&";
    private static String bboxDim = "&width=2&height=2&x=1&y=1";

    public SolinstralningResponse getSoldata(Double longitude, Double latitude) {
        String lng_add =  Double.toString(longitude + 0.0001);
        String lat_add = Double.toString(latitude + 0.0001);
        String uri = "http://kartor.miljo.stockholm.se/geoserver/wms?" + byggLayers + reqType + coord + queryByggLayers +
                "bbox=" + longitude + "," + latitude + "," + lng_add + "," + lat_add + bboxDim;

        logger.info("Wms url: " + uri);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.parseMediaType("text/plain")));
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        String rawResponse = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class).getBody();

        logger.info("Raw response: " + rawResponse);

        SolinstralningResponse solinstralningResponse = new SolinstralningResponse();

        int index_takyta = rawResponse.indexOf("takyta");
        String takyta = rawResponse.toString().substring(index_takyta + 9, index_takyta + 12);
        solinstralningResponse.setTakyta(takyta);

        return solinstralningResponse;
    }
}
