package com.modaljoa.tft.service;

import com.modaljoa.tft.dto.league.LeagueListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.modaljoa.tft.info.StringInfo.*;

@Service
@RequiredArgsConstructor
public class GrandmasterInfoService {

    private final RestTemplateBuilder restTemplateBuilder;

    public LeagueListDTO getGrandmasterInfo() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);

        LeagueListDTO grandmasterInfo = restTemplate.getForObject(getGrandmasterUsers + "?api_key=" + apiKey, LeagueListDTO.class);

        return grandmasterInfo;
    }
}
