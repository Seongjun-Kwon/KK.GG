package com.modaljoa.tft.vo.riotApi.league.topTierUser;

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
