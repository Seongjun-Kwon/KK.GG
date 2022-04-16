package com.modaljoa.tft.service;

import com.modaljoa.tft.dto.summoner.LeagueEntryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

import static com.modaljoa.tft.info.StringInfo.*;

@Service
@RequiredArgsConstructor
public class LeagueInfoService {

    private final RestTemplateBuilder restTemplateBuilder;

    public HashSet<LeagueEntryDTO> getLeagueInfo(String summonerId) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);

        HashSet<LeagueEntryDTO> leagueInfo = restTemplate.getForObject(findLeagueInfoBySummonerId + summonerId + "?api_key=" + apiKey, HashSet.class);

        return leagueInfo;
    }
}
