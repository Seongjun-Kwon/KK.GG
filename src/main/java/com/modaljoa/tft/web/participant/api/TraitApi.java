package com.modaljoa.tft.web.participant.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TraitApi {
    private String name;

    @JsonProperty(value = "num_units")
    private int numUnits;
    private int style;

    @JsonProperty(value = "tier_current")
    private int tierCurrent;

    @JsonProperty(value = "tier_total")
    private int tierTotal;
}
