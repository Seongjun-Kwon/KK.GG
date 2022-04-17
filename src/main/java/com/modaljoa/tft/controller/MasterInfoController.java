package com.modaljoa.tft.controller;

import com.modaljoa.tft.dto.league.LeagueListDTO;
import com.modaljoa.tft.service.MasterInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MasterInfoController {

    private final MasterInfoService masterInfoService;

    @GetMapping("/tft/league/v1/master")
    public LeagueListDTO findMasterInfo() {
        return masterInfoService.getMasterInfo();
    }
}
