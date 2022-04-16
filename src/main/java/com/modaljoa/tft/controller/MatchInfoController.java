package com.modaljoa.tft.controller;

import com.modaljoa.tft.dto.match.MatchDto;
import com.modaljoa.tft.service.MatchInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MatchInfoController {

    private final MatchInfoService matchInfoService;

    @GetMapping("/tft/match/v1/matches/{matchId}")
    public MatchDto findMatchInfo(@PathVariable String matchId) {
        return matchInfoService.getMatchInfo(matchId);
    }
}
