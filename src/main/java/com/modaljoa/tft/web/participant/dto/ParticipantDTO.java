package com.modaljoa.tft.web.participant.dto;

import com.modaljoa.tft.web.participant.api.CompanionApi;
import com.modaljoa.tft.web.participant.api.ParticipantApi;
import com.modaljoa.tft.web.participant.api.TraitApi;
import com.modaljoa.tft.web.participant.api.UnitApi;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParticipantDTO {
    private CompanionDTO companion;
    private int goldLeft;
    private int lastRound;
    private int level;
    private int placement;
    private float timeEliminated;
    private List<TraitDTO> traits;
    private List<UnitDTO> units;

    public ParticipantDTO(ParticipantApi participant) {
        this.companion = getCompanionDto(participant.getCompanion());
        this.goldLeft = participant.getGoldLeft();
        this.lastRound = participant.getLastRound();
        this.level = participant.getLevel();
        this.placement = participant.getPlacement();
        this.timeEliminated = participant.getTimeEliminated();
        this.traits = getTraitDtoList(participant.getTraits());
        this.units = getUnitDtoList(participant.getUnits());
    }

    public CompanionDTO getCompanionDto(CompanionApi companion) {
        CompanionDTO companionDTO = new CompanionDTO();

        companionDTO.setContentId(companion.getContentId());
        companionDTO.setSpecies(companion.getSpecies());
        companionDTO.setSkinId(companion.getSkinId());

        return companionDTO;
    }

    public List<TraitDTO> getTraitDtoList(List<TraitApi> traits) {
        List<TraitDTO> traitDtoList = new ArrayList<>();

        for (TraitApi trait : traits) {
            TraitDTO traitDTO = new TraitDTO(trait);
            traitDtoList.add(traitDTO);
        }

        return traitDtoList;
    }

    public List<UnitDTO> getUnitDtoList(List<UnitApi> units) {
        List<UnitDTO> unitDtoList = new ArrayList<>();

        for (UnitApi unit : units) {
            UnitDTO unitDTO = new UnitDTO(unit);
            unitDtoList.add(unitDTO);
        }

        return unitDtoList;
    }
}
