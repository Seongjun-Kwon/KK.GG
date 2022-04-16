package com.modaljoa.tft.dto.match;

import lombok.Data;

import java.util.List;

@Data
public class UnitDto {
    private List<Integer> items;
    private String character_id;
    private String chosen;
    private String name;
    private int rarity;
    private int tier;
}
