package com.modaljoa.tft.controller;

import com.modaljoa.tft.dto.league.LeagueListDTO;
import com.modaljoa.tft.service.GrandmasterInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GrandmasterInfoController {

    private final GrandmasterInfoService grandmasterInfoService;

    @GetMapping("/tft/league/v1/grandmaster")
    public LeagueListDTO findGrandmasterInfo() {
        return grandmasterInfoService.getGrandmasterInfo();
    }
}
