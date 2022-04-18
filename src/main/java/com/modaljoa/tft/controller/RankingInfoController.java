package com.modaljoa.tft.controller;

import com.modaljoa.tft.dto.league.LeagueListDTO;
import com.modaljoa.tft.service.RankingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RankingInfoController {

    private final RankingInfoService rankingInfoService;

    @GetMapping("/tft/league/v1/{tier}")
    public LeagueListDTO findTopTierInfo(@PathVariable String tier) {
        return rankingInfoService.getTopTierInfo(tier);
    }
}
