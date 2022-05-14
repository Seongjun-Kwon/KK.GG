package com.modaljoa.tft.vo.riotApi.match.matchId;

import lombok.Data;

import java.util.List;

@Data
public class Info {
    private long gameDatetime;
    private float gameLength;
    private String gameVariation;
    private String gameVersion;
    private List<Participant> participants;
    private int queueId;
    private int tftSetNumber;
}
