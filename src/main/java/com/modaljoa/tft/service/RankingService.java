package com.modaljoa.tft.service;

import com.modaljoa.tft.dto.RankingDTO;
import com.modaljoa.tft.dto.SummonerLeagueDTO;
import com.modaljoa.tft.vo.riotApi.league.summonerId.LeagueEntry;
import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueList;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.modaljoa.tft.info.StringInfo.*;

@Service
@RequiredArgsConstructor
public class RankingService {

    private final RestTemplateBuilder restTemplateBuilder;

    public RankingDTO getTopTierUsers(String tier) { // challenger, grandmaster, master
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        LeagueList leagueList = restTemplate.getForObject(getTopTierUsers + tier + "?api_key=" + apiKey, LeagueList.class);
        RankingDTO rankingDTO = new RankingDTO(leagueList);

        return rankingDTO;
    }

    public List<SummonerLeagueDTO> getLowTierUsers(String tier, String division) { // diamond ~ bronze
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        List<SummonerLeagueDTO> leagueDTOs = new ArrayList<>();

        LeagueEntry[] leagueEntries = restTemplate.getForObject(getLowTierUsers + tier + "/" + division + "?api_key=" + apiKey, LeagueEntry[].class);
        for (LeagueEntry leagueEntry : leagueEntries) {
            SummonerLeagueDTO leagueDTO = new SummonerLeagueDTO(leagueEntry);
            leagueDTOs.add(leagueDTO);
        }

        return leagueDTOs;
    }

    private void setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);
    }
}