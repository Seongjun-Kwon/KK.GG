package com.modaljoa.tft.controller;

import com.modaljoa.tft.service.RankingInfoService;
import com.modaljoa.tft.vo.riotApi.league.summonerId.LeagueEntry;
import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequiredArgsConstructor
public class RankingInfoController {

    private final RankingInfoService rankingInfoService;

    @GetMapping("/tft/league/v1/{tier}")
    public LeagueList findTopTierInfo(@PathVariable String tier) {
        return rankingInfoService.getTopTierInfo(tier);
    }

    @GetMapping("/tft/league/v1/entries/{tier}/{division}")
    public HashSet<LeagueEntry> findLowTierInfo(@PathVariable String tier, @PathVariable String division) {
        return rankingInfoService.getLowTierInfo(tier, division);
    }
}
