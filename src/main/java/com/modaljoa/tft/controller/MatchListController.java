package com.modaljoa.tft.controller;

import com.modaljoa.tft.service.MatchListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchListController {

    private final MatchListService matchListService;

    @GetMapping("/tft/match/v1/matches/by-puuid/{puuid}/ids")
    public List<String> findMatchIds(@PathVariable String puuid) {
        return matchListService.getMatchIds(puuid);
    }
}
