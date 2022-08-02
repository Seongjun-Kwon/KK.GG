package com.modaljoa.tft.vo.riotApi.league.topTierUser;

import com.modaljoa.tft.vo.riotApi.league.summonerId.MiniSeriesApi;
import lombok.Data;

@Data
public class LeagueItemApi {

    private boolean freshBlood;
    private int wins;
    private String summonerName;
    private MiniSeriesApi miniSeries;
    private boolean inactive;
    private boolean veteran;
    private boolean hotStreak;
    private String rank;
    private int leaguePoints;
    private int losses;
    private String summonerId;
}
