package com.modaljoa.tft.dto;

import com.modaljoa.tft.vo.riotApi.summoner.summonerName.SummonerApi;
import lombok.Data;

@Data
public class SummonerDTO {

    private String summonerName;
    private int profileIconId;
    private long summonerLevel;

    public SummonerDTO(SummonerApi summoner) {
        this.summonerName = summoner.getName();
        this.profileIconId = summoner.getProfileIconId();
        this.summonerLevel = summoner.getSummonerLevel();
    }
}
