package com.modaljoa.tft.vo.riotApi.league;

import lombok.Data;

import java.util.List;

@Data
public class LeagueList {

    private String leagueId;
    private List<LeagueItem> entries;
    private String tier;
    private String name;
    private String queue;
}
