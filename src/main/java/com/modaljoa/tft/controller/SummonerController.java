package com.modaljoa.tft.controller;

import com.modaljoa.tft.dto.summoner.SummonerDTO;
import com.modaljoa.tft.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SummonerController {

    private final SummonerService summonerService;

    @GetMapping("/summoner/{summonerName}")
    public SummonerDTO findBySummonerName(@PathVariable String summonerName) {
        return summonerService.find(summonerName);
    }
}
