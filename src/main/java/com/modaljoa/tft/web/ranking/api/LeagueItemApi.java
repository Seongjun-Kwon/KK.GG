package com.modaljoa.tft.web.ranking.api;

import com.modaljoa.tft.web.summoner.api.MiniSeriesApi;
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
