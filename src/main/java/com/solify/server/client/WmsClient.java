package com.solify.server.client;

import com.solify.server.controller.response.SolinstralningResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;

@Component
public class WmsClient {
    public static Logger logger = LogManager.getLogger();

    private static String byggLayers = "layers=mftemp:solinstralning-2012-byggnader&";
    private static String reqType = "request=GetFeatureInfo&";
    private static String coord = "CRS=CRS:84&";
    private static String queryByggLayers = "QUERY_LAYERS=mftemp:solinstralning-2012-byggnader&";
    private static String bboxDim = "&width=2&height=2&x=1&y=1";

    public HashMap<String, Integer> getSoldata(Double longitude, Double latitude) {
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

        HashMap<String, Integer> responseMap = getSolinstralningResponse(rawResponse);


        return responseMap;
    }

    private HashMap<String, Integer> getSolinstralningResponse(String rawResponse) {

        HashMap<String, Integer> responseMap = parseResponse(rawResponse);
        return responseMap;
    }

    private HashMap<String, Integer> parseResponse(String rawResponse) {
        String responseLines[] = rawResponse.split("\\r?\\n");
        HashMap<String, Integer> responseMap = new HashMap<String, Integer>();

        for (String responseLine: responseLines) {
            int index_equals = responseLine.indexOf("=");

            if(index_equals == -1)
                continue;

            String key = responseLine.substring(0, index_equals - 1);
            try {
                String value = responseLine.substring(index_equals + 2);
                responseMap.put(key, Integer.parseInt(value));
            } catch (NumberFormatException e) {
                logger.info("Not an integer");
            }
        }
        return responseMap;
    }
}
