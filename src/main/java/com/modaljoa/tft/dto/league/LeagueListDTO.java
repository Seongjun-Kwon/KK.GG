package com.modaljoa.tft.dto.league;

import lombok.Data;

import java.util.List;

@Data
public class LeagueListDTO {

    private String leagueId;
    private List<LeagueItemDTO> entries;
    private String tier;
    private String name;
    private String queue;
}
