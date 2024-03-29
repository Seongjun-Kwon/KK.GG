package com.modaljoa.tft.web.match.controller;

import com.modaljoa.tft.web.match.dto.MatchDTO;
import com.modaljoa.tft.domain.match.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping("/profile/kr/match/{summonerName}")
    public List<MatchDTO> getMatchInfo(@PathVariable String summonerName, Model model) {

        List<MatchDTO> matchDetailList = matchService.getMatchDetailList(summonerName);

        return matchDetailList;
    }
}
