package com.modaljoa.tft.vo.riotApi.match.matchId;

import lombok.Data;

import java.util.List;

@Data
public class Metadata {
    private String dataVersion;
    private String matchId;
    private List<String> participants;
}