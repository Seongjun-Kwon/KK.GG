package com.modaljoa.tft.dto;

import lombok.Data;

import java.util.List;

@Data
public class ParticipantDto {
    private int gold_left;
    private int last_round;
    private int level;
    private int placement;
    private int players_eliminated;
    private String puuid;
    private float time_eliminated;
    private int total_damage_to_players;
    private List<TraitDto> traits;
    private List<UnitDto> units;
}
