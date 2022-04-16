package com.modaljoa.tft.controller;

import com.modaljoa.tft.dto.league.LeagueListDTO;
import com.modaljoa.tft.service.ChallengerInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChallengerInfoController {

    private final ChallengerInfoService challengerInfoService;

    @GetMapping("/tft/league/v1/challenger")
    public LeagueListDTO findChallengerInfo() {
        return challengerInfoService.getChallengerInfo();
    }
}
