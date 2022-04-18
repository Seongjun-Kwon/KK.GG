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
public class RankingInfoService {

    private final RestTemplateBuilder restTemplateBuilder;

    public LeagueListDTO getTopTierInfo(String tier) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();
        LeagueListDTO topTierInfo = restTemplate.getForObject(getTopTierUsers + tier + "?api_key=" + apiKey, LeagueListDTO.class);

        return topTierInfo;
    }

    private void setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);
    }
}