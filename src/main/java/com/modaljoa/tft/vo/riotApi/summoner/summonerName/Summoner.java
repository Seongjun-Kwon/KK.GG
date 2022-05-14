package com.modaljoa.tft.vo.riotApi.summoner.summonerName;

import lombok.Data;

@Data
public class Summoner {
    private String accountId;
    private int profileIconId;
    private long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;
}
