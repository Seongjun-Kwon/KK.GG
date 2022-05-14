package com.modaljoa.tft.service;

import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueList;
import com.modaljoa.tft.vo.riotApi.summoner.LeagueEntryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

import static com.modaljoa.tft.info.StringInfo.*;

@Service
@RequiredArgsConstructor
public class RankingInfoService {

    private final RestTemplateBuilder restTemplateBuilder;

    public LeagueList getTopTierInfo(String tier) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();
        LeagueList topTierInfo = restTemplate.getForObject(getTopTierUsers + tier + "?api_key=" + apiKey, LeagueList.class);

        return topTierInfo;
    }

    public HashSet<LeagueEntryDTO> getLowTierInfo(String tier, String division) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();
        HashSet<LeagueEntryDTO> lowTierInfo = restTemplate.getForObject(getLowTierUsers + tier + "/" + division + "?api_key=" + apiKey, HashSet.class);

        return lowTierInfo;
    }

    private void setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);
    }
}