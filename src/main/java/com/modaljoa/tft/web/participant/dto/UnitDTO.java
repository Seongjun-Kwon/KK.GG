package com.modaljoa.tft.web.participant.dto;

import com.modaljoa.tft.web.participant.api.UnitApi;
import lombok.Data;

import java.util.List;

@Data
public class UnitDTO {
    private List<Integer> items;
    private String characterId;
    private String chosen;
    private String unitName;
    private int rarity;
    private int tier;

    public UnitDTO(UnitApi unit) {
        this.items = unit.getItems();
        this.characterId = unit.getCharacterId();
        this.chosen = unit.getChosen();
        this.unitName = unit.getName();
        this.rarity = unit.getRarity();
        this.tier = unit.getTier();
    }
}
