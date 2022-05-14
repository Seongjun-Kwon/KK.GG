package com.modaljoa.tft.service;

import com.modaljoa.tft.vo.riotApi.match.matchId.Match;
import com.modaljoa.tft.vo.riotApi.league.summonerId.LeagueEntry;
import com.modaljoa.tft.vo.riotApi.summoner.summonerName.Summoner;
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

    public Summoner getSummoner(String summonerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        Summoner summoner = restTemplate.getForObject(getSummoner + summonerName + "?api_key=" + apiKey, Summoner.class);

        return summoner;
    }

    public List<String> getMatchIdList(Summoner summoner) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        String puuid = summoner.getPuuid();
        List<String> matchIdList = restTemplate.getForObject(getMatchIdList + puuid + "/ids?count=20&api_key=" + apiKey, List.class);

        return matchIdList;
    }

    public List<Match> getMatchDetailList(Summoner summoner) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        List<String> matchIdList = getMatchIdList(summoner);
        List<Match> matchDetailList = new ArrayList<>();

        for (String matchId : matchIdList) {
            Match matchDetail = restTemplate.getForObject(getMatchDetail + matchId + "?api_key=" + apiKey, Match.class);
            matchDetailList.add(matchDetail);
        }

        return matchDetailList;
    }

    public HashSet<LeagueEntry> getLeagueInfo(Summoner summoner) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        String summonerId = summoner.getId();
        HashSet<LeagueEntry> leagueInfo = restTemplate.getForObject(getLeagueInfo + summonerId + "?api_key=" + apiKey, HashSet.class);

        return leagueInfo;
    }

    private void setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);
    }
}