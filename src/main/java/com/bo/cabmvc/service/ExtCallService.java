package com.bo.cabmvc.service;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

/**
 * @author Ozads
 * @version v1.0
 * @project cab-mvc
 * @since 2024-08-01
 **/
@Service
@RequiredArgsConstructor
public class ExtCallService {

    private final RestClient restClient;

    public Map<String,Object> getData(){
        return restClient.get()
            .uri("/store/inventory")
            .retrieve()
            .body(Map.class);
    }


}
