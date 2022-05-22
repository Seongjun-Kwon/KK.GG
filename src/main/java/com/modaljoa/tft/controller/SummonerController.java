package com.modaljoa.tft.controller;

import com.modaljoa.tft.dto.SummonerDTO;
import com.modaljoa.tft.dto.SummonerLeagueDTO;
import com.modaljoa.tft.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SummonerController {

    private final SummonerService summonerService;

//    @GetMapping("/profile/kr/{summonerName}")
//    public String getSummonerInfo(@PathVariable String summonerName, Model model) {
//
//        SummonerDTO summonerDTO = summonerService.getSummonerDTO(summonerName);
//        List<MatchDTO> matchDetailList = summonerService.getMatchDetailList(summonerName);
//
//        model.addAttribute(summonerDTO);
//        model.addAttribute(matchDetailList);
//
//        return "";
//    }

    @GetMapping("/profile/kr/{summonerName}")
    public SummonerDTO getSummonerBasicInfo(@PathVariable String summonerName) {

        SummonerDTO summonerDTO = summonerService.getSummonerDTO(summonerName);

        return summonerDTO;
    }

    @GetMapping("/profile/kr/league/{summonerName}")
    public SummonerLeagueDTO getSummonerLeague(@PathVariable String summonerName) {

        SummonerLeagueDTO summonerLeagueDTO = summonerService.getSummonerLeague(summonerName);

        return summonerLeagueDTO;
    }
}
