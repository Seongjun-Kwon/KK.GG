package com.modaljoa.tft.web.summoner.api;

import lombok.Data;

@Data
public class SummonerApi {
    private String accountId;
    private int profileIconId;
    private long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;
}
