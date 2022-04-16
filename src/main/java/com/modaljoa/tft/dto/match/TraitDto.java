package com.modaljoa.tft.dto.match;

import lombok.Data;

@Data
public class TraitDto {
    private String name;
    private int num_units;
    private int style;
    private int tier_current;
    private int tier_total;
}
