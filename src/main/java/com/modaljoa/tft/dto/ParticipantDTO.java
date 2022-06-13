package com.modaljoa.tft.dto;

import com.modaljoa.tft.vo.riotApi.match.matchId.Companion;
import com.modaljoa.tft.vo.riotApi.match.matchId.Participant;
import com.modaljoa.tft.vo.riotApi.match.matchId.Trait;
import com.modaljoa.tft.vo.riotApi.match.matchId.Unit;
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

    public ParticipantDTO(Participant participant) {
        this.companion = getCompanionDto(participant.getCompanion());
        this.goldLeft = participant.getGoldLeft();
        this.lastRound = participant.getLastRound();
        this.level = participant.getLevel();
        this.placement = participant.getPlacement();
        this.timeEliminated = participant.getTimeEliminated();
        this.traits = getTraitDtoList(participant.getTraits());
        this.units = getUnitDtoList(participant.getUnits());
    }

    public CompanionDTO getCompanionDto(Companion companion) {
        CompanionDTO companionDTO = new CompanionDTO();

        companionDTO.setContentId(companion.getContentId());
        companionDTO.setSpecies(companion.getSpecies());
        companionDTO.setSkinId(companion.getSkinId());

        return companionDTO;
    }

    public List<TraitDTO> getTraitDtoList(List<Trait> traits) {
        List<TraitDTO> traitDtoList = new ArrayList<>();

        for (Trait trait : traits) {
            TraitDTO traitDTO = new TraitDTO(trait);
            traitDtoList.add(traitDTO);
        }

        return traitDtoList;
    }

    public List<UnitDTO> getUnitDtoList(List<Unit> units) {
        List<UnitDTO> unitDtoList = new ArrayList<>();

        for (Unit unit : units) {
            UnitDTO unitDTO = new UnitDTO(unit);
            unitDtoList.add(unitDTO);
        }

        return unitDtoList;
    }
}
