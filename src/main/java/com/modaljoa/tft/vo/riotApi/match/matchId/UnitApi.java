package com.modaljoa.tft.vo.riotApi.match.matchId;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UnitApi {
    private List<Integer> items;

    @JsonProperty(value = "character_id")
    private String characterId;
    private String chosen;
    private String name;
    private int rarity;
    private int tier;
}
