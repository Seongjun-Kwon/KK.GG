package com.modaljoa.tft.vo.riotApi.match;

import lombok.Data;

import java.util.List;

@Data
public class Unit {
    private List<Integer> items;
    private String character_id;
    private String chosen;
    private String name;
    private int rarity;
    private int tier;
}
