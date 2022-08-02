package com.modaljoa.tft.dto;

import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueItemApi;
import lombok.Data;

@Data
public class RankingItemDTO {

    private String summonerName;
    private String rank;
    private int wins;
    private int leaguePoints;
    private int losses;

    public RankingItemDTO(LeagueItemApi leagueItem) {
        this.summonerName = leagueItem.getSummonerName();
        this.rank = leagueItem.getRank();
        this.wins = leagueItem.getWins();
        this.leaguePoints = leagueItem.getLeaguePoints();
        this.losses = leagueItem.getLosses();
    }
}
