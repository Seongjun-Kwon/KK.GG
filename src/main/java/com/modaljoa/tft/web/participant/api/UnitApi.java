package com.modaljoa.tft.web.participant.api;

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
