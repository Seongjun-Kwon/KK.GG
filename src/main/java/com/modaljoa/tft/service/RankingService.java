package com.modaljoa.tft.service;

import com.modaljoa.tft.dto.RankingDTO;
import com.modaljoa.tft.dto.RankingItemDTO;
import com.modaljoa.tft.dto.SummonerLeagueDTO;
import com.modaljoa.tft.vo.riotApi.league.summonerId.LeagueEntryApi;
import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueListApi;
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

        LeagueListApi leagueList = restTemplate.getForObject(getTopTierUsers + tier + "?api_key=" + apiKey, LeagueListApi.class);
        RankingDTO rankingDTO = new RankingDTO(leagueList);

        return rankingDTO;
    }

    public List<SummonerLeagueDTO> getLowTierUsers(String tier, String division) { // diamond ~ bronze
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        List<SummonerLeagueDTO> leagueDTOs = new ArrayList<>();

        LeagueEntryApi[] leagueEntries = restTemplate.getForObject(getLowTierUsers + tier + "/" + division + "?api_key=" + apiKey, LeagueEntryApi[].class);
        for (LeagueEntryApi leagueEntry : leagueEntries) {
            SummonerLeagueDTO leagueDTO = new SummonerLeagueDTO(leagueEntry);
            leagueDTOs.add(leagueDTO);
        }

        return leagueDTOs;
    }

    public List<RankingItemDTO> getListPaging(RankingDTO rankingDTO, int startIdx, int pageSize) {
        List<RankingItemDTO> entries = rankingDTO.getEntries();
        List<RankingItemDTO> pagingEntries = new ArrayList<>();

        for (int i = startIdx - 1; i < startIdx + pageSize - 1; i++) {
            if (i < entries.size()) {
                pagingEntries.add(entries.get(i));
            }
        }

        return pagingEntries;
    }

    private void setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);
    }
}