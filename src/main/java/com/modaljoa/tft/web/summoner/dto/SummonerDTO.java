package com.modaljoa.tft.web.summoner.dto;

import com.modaljoa.tft.web.summoner.api.SummonerApi;
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
