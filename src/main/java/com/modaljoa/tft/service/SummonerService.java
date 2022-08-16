package com.modaljoa.tft.service;

import com.modaljoa.tft.dto.SummonerDTO;
import com.modaljoa.tft.dto.SummonerLeagueDTO;
import com.modaljoa.tft.repository.SummonerRepository;
import com.modaljoa.tft.vo.db.Summoner;
import com.modaljoa.tft.vo.riotApi.league.summonerId.LeagueEntryApi;
import com.modaljoa.tft.vo.riotApi.summoner.summonerName.SummonerApi;
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
    private final SummonerRepository summonerRepository;

    public SummonerApi getSummoner(String summonerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        SummonerApi summoner = restTemplate.getForObject(getSummoner + summonerName + "?api_key=" + apiKey, SummonerApi.class);

        return summoner;
    }

    public SummonerDTO getSummonerDTO(String summonerName) {
        SummonerApi summonerApi = getSummoner(summonerName);
        SummonerLeagueDTO summonerLeagueDTO = getSummonerLeague(summonerName);
        Summoner summonerDb = summonerRepository.findByName(summonerName);

        if (summonerDb == null) {
            summonerDb = new Summoner(summonerApi, summonerLeagueDTO);
            summonerRepository.save(summonerDb);
        } else if (summonerDb.isChanged(summonerApi, summonerLeagueDTO)) {
            summonerDb.updateSummoner(summonerApi, summonerLeagueDTO);
            summonerRepository.save(summonerDb);
        }

        SummonerDTO summonerDTO = new SummonerDTO(summonerApi);

        return summonerDTO;
    }

    public SummonerLeagueDTO getSummonerLeague(String summonerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        String summonerId = getSummoner(summonerName).getId();
        LeagueEntryApi[] leagueEntries = restTemplate.getForObject(getSummonerLeagueInfo + summonerId + "?api_key=" + apiKey, LeagueEntryApi[].class);

        SummonerLeagueDTO summonerLeagueDTO = new SummonerLeagueDTO(leagueEntries[0]);

        return summonerLeagueDTO;
    }

    private void setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);
    }
}