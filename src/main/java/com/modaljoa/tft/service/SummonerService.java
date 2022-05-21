package com.modaljoa.tft.service;

import com.modaljoa.tft.dto.MatchDTO;
import com.modaljoa.tft.dto.SummonerDTO;
import com.modaljoa.tft.vo.riotApi.match.matchId.Match;
import com.modaljoa.tft.vo.riotApi.summoner.summonerName.Summoner;
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
public class SummonerService {

    private final RestTemplateBuilder restTemplateBuilder;

    public Summoner getSummoner(String summonerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        Summoner summoner = restTemplate.getForObject(getSummoner + summonerName + "?api_key=" + apiKey, Summoner.class);

        return summoner;
    }

    public SummonerDTO getSummonerDTO(String summonerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        Summoner summoner = restTemplate.getForObject(getSummoner + summonerName + "?api_key=" + apiKey, Summoner.class);
        SummonerDTO summonerDTO = new SummonerDTO(summoner);

        return summonerDTO;
    }

    public List<String> getMatchIdList(String summonerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        Summoner summoner = getSummoner(summonerName);
        String puuid = summoner.getPuuid();
        List<String> matchIdList = restTemplate.getForObject(getMatchIdList + puuid + "/ids?count=20&api_key=" + apiKey, List.class);

        return matchIdList;
    }

    public List<MatchDTO> getMatchDetailList(String summonerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        List<String> matchIdList = getMatchIdList(summonerName);
        List<MatchDTO> matchDetailList = new ArrayList<>();

        for (String matchId : matchIdList) {
            Match match = restTemplate.getForObject(getMatchDetail + matchId + "?api_key=" + apiKey, Match.class);
            MatchDTO matchDTO = new MatchDTO(match);
            matchDetailList.add(matchDTO);
        }

        return matchDetailList;
    }

//    public SummonerLeagueDTO getSummonerLeagueInfo(String summonerName) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        setHeaders();
//
//        String summonerId = getSummoner(summonerName).getId();
//        LeagueEntry leagueEntry = restTemplate.getForObject(getSummonerLeagueInfo + summonerId + "?api_key=" + apiKey, LeagueEntry.class);
//
//        SummonerLeagueDTO summonerLeagueDTO = new SummonerLeagueDTO(leagueEntry);
//
//        return summonerLeagueDTO;
//    }

    private void setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);
    }
}