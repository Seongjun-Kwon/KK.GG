package com.modaljoa.tft.controller;

import com.modaljoa.tft.dto.LeagueEntryDTO;
import com.modaljoa.tft.service.LeagueInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequiredArgsConstructor
public class LeagueInfoController {

    private final LeagueInfoService leagueInfoService;

    @GetMapping("/tft/league/v1/entries/by-summoner/{summonerId}")
    public HashSet<LeagueEntryDTO> findLeagueInfo(@PathVariable String summonerId) {
        return leagueInfoService.getLeagueInfo(summonerId);
    }
}
