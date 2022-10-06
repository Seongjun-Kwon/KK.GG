package com.modaljoa.tft.web.ranking.api;

import lombok.Data;

import java.util.List;

@Data
public class LeagueListApi {

    private String leagueId;
    private List<LeagueItemApi> entries;
    private String tier;
    private String name;
    private String queue;
}
