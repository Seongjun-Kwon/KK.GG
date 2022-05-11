package com.modaljoa.tft.vo.riotApi.league;

import com.modaljoa.tft.vo.riotApi.summoner.MiniSeries;
import lombok.Data;

@Data
public class LeagueItem {

    private boolean freshBlood;
    private int wins;
    private String summonerName;
    private MiniSeries miniSeries;
    private boolean inactive;
    private boolean veteran;
    private boolean hotStreak;
    private String rank;
    private int leaguePoints;
    private int losses;
    private String summonerId;
}
