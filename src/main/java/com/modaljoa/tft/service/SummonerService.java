package com.modaljoa.tft.service;

import com.modaljoa.tft.dto.summoner.SummonerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.modaljoa.tft.info.StringInfo.*;

@Service
@RequiredArgsConstructor
public class SummonerService {

    private final RestTemplateBuilder restTemplateBuilder;

    public SummonerDTO find(String summonerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);

        SummonerDTO summonerDTO = restTemplate.getForObject(findBySummonerName + summonerName + "?api_key=" + apiKey, SummonerDTO.class);

        return summonerDTO;
    }
}
