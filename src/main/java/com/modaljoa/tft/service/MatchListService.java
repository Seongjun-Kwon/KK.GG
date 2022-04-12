package com.modaljoa.tft.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.modaljoa.tft.info.StringInfo.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class MatchListService {

    private final RestTemplateBuilder restTemplateBuilder;

    public List<String> getMatchIds(String puuid) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);

        List<String> matchIds = restTemplate.getForObject(findMatchIdsByPuuid + puuid + "/ids?count=20&api_key=" + apiKey, List.class);

        return matchIds;
    }
}
