package com.modaljoa.tft.service;

import com.modaljoa.tft.dto.MatchDTO;
import com.modaljoa.tft.repository.MatchRepository;
import com.modaljoa.tft.repository.ParticipantRepository;
import com.modaljoa.tft.repository.SummonerRepository;
import com.modaljoa.tft.vo.db.Match;
import com.modaljoa.tft.vo.db.Participant;
import com.modaljoa.tft.vo.riotApi.match.matchId.MatchApi;
import com.modaljoa.tft.vo.riotApi.match.matchId.ParticipantApi;
import com.modaljoa.tft.vo.riotApi.summoner.summonerName.SummonerApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.modaljoa.tft.info.StringInfo.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchService {

    private final RestTemplateBuilder restTemplateBuilder;
    private final SummonerRepository summonerRepository;
    private final MatchRepository matchRepository;
    private final ParticipantRepository participantRepository;

    public List<String> getMatchIdList(String summonerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        setHeaders();

        SummonerApi summoner = restTemplate.getForObject(getSummoner + summonerName + "?api_key=" + apiKey, SummonerApi.class);
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
            MatchApi matchApi = restTemplate.getForObject(getMatchDetail + matchId + "?api_key=" + apiKey, MatchApi.class);

            Match matchDb = new Match(matchApi);
            matchRepository.save(matchDb);

            List<ParticipantApi> participantApiList = matchApi.getInfo().getParticipants();
            for (ParticipantApi participantApi : participantApiList) {
                Participant participantDb = new Participant(participantApi);
                participantDb.setMatch(matchDb);
                participantRepository.save(participantDb);
            }

            MatchDTO matchDTO = new MatchDTO(matchApi);
            matchDetailList.add(matchDTO);
        }

        return matchDetailList;
    }

    private void setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT_CHARSET, "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set(HttpHeaders.ORIGIN, requestHeaderOrigin);
    }
}
