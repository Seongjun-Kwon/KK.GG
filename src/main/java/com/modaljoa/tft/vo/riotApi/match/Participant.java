package com.modaljoa.tft.vo.riotApi.match;

import lombok.Data;

import java.util.List;

@Data
public class Participant {
    private int gold_left;
    private int last_round;
    private int level;
    private int placement;
    private int players_eliminated;
    private String puuid;
    private float time_eliminated;
    private int total_damage_to_players;
    private List<Trait> traits;
    private List<Unit> units;
}
