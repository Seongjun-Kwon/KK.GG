package com.modaljoa.tft.web.participant.dto;

import com.modaljoa.tft.web.participant.api.TraitApi;
import lombok.Data;

@Data
public class TraitDTO {
    private String traitName;
    private int numUnits;
    private int style;
    private int tierCurrent;
    private int tierTotal;

    public TraitDTO(TraitApi trait) {
        this.traitName = trait.getName();
        this.numUnits = trait.getNumUnits();
        this.style = trait.getStyle();
        this.tierCurrent = trait.getTierCurrent();
        this.tierTotal = trait.getTierTotal();
    }
}
