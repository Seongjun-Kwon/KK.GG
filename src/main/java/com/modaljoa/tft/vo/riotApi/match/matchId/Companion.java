package com.modaljoa.tft.vo.riotApi.match.matchId;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Companion { // 꼬마 전설이

    private String contentId;
    private int skinId;
    private String species;
}
