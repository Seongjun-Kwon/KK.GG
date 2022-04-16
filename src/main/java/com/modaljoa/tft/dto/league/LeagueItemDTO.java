package com.modaljoa.tft.dto.league;

import com.modaljoa.tft.dto.summoner.MiniSeriesDTO;
import lombok.Data;

@Data
public class LeagueItemDTO {

    private boolean freshBlood;
    private int wins;
    private String summonerName;
    private MiniSeriesDTO miniSeries;
    private boolean inactive;
    private boolean veteran;
    private boolean hotStreak;
    private String rank;
    private int leaguePoints;
    private int losses;
    private String summonerId;
}
