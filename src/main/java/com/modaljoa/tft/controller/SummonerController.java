package com.modaljoa.tft.controller;

import com.modaljoa.tft.dto.match.MatchDto;
import com.modaljoa.tft.dto.summoner.LeagueEntryDTO;
import com.modaljoa.tft.dto.summoner.SummonerDTO;
import com.modaljoa.tft.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SummonerController {

    private final SummonerService summonerService;

    @GetMapping("/profile/kr/{summonerName}")
    public String getSummonerInfo(@PathVariable String summonerName, Model model) {

        SummonerDTO summoner = summonerService.getSummoner(summonerName);
        List<MatchDto> matchDetailList = summonerService.getMatchDetailList(summoner);
        HashSet<LeagueEntryDTO> leagueInfo = summonerService.getLeagueInfo(summoner);

        model.addAttribute(summoner);
        model.addAttribute(matchDetailList);
        model.addAttribute(leagueInfo);

        return "";
    }
}
