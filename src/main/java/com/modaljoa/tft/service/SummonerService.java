package com.modaljoa.tft.service;

import com.modaljoa.tft.dto.match.MatchDto;
import com.modaljoa.tft.dto.summoner.LeagueEntryDTO;
import com.modaljoa.tft.dto.summoner.SummonerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.modaljoa.tft.info.StringInfo.*;

@Service
@RequiredArgsConstructor
public class SummonerService {

    private final RestTemplateBuilder restTemplateBuilder;

    public SummonerDTO getSummoner(String summonerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        SummonerDTO summonerDTO = restTemplate.getForObject(getSummoner + summonerName + "?api_key=" + apiKey, SummonerDTO.class);

        return summonerDTO;
    }

    public List<String> getMatchIdList(SummonerDTO summoner) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        String puuid = summoner.getPuuid();
        List<String> matchIdList = restTemplate.getForObject(getMatchIdList + puuid + "/ids?count=20&api_key=" + apiKey, List.class);

        return matchIdList;
    }

    public List<MatchDto> getMatchDetailList(SummonerDTO summoner) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        List<String> matchIdList = getMatchIdList(summoner);
        List<MatchDto> matchDetailList = new ArrayList<>();

        for (String matchId : matchIdList) {
            MatchDto matchDetail = restTemplate.getForObject(getMatchDetail + matchId + "?api_key=" + apiKey, MatchDto.class);
            matchDetailList.add(matchDetail);
        }

        return matchDetailList;
    }

    public HashSet<LeagueEntryDTO> getLeagueInfo(SummonerDTO summoner) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        String summonerId = summoner.getId();
        HashSet<LeagueEntryDTO> leagueInfo = restTemplate.getForObject(getLeagueInfo + summonerId + "?api_key=" + apiKey, HashSet.class);

        return leagueInfo;
    }

    private void setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);
    }
}