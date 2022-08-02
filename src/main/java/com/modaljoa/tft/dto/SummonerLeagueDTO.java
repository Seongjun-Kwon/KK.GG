package com.modaljoa.tft.dto;

import com.modaljoa.tft.vo.riotApi.league.summonerId.LeagueEntryApi;
import lombok.Data;

@Data
public class SummonerLeagueDTO {

    private String summonerName;
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;

    public SummonerLeagueDTO(LeagueEntryApi leagueEntry) {
        this.summonerName = leagueEntry.getSummonerName();
        this.tier = leagueEntry.getTier();
        this.rank = leagueEntry.getRank();
        this.leaguePoints = leagueEntry.getLeaguePoints();
        this.wins = leagueEntry.getWins();
        this.losses = leagueEntry.getLosses();
    }
}
