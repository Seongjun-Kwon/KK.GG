package com.modaljoa.tft.web.participant.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ParticipantApi {
    private CompanionApi companion;

    @JsonProperty(value = "gold_left")
    private int goldLeft;

    @JsonProperty(value = "last_round")
    private int lastRound;
    private int level;
    private int placement;

    @JsonProperty(value = "players_eliminated")
    private int playersEliminated;
    private String puuid;

    @JsonProperty(value = "time_eliminated")
    private float timeEliminated;

    @JsonProperty(value = "total_damage_to_players")
    private int totalDamageToPlayers;
    private List<TraitApi> traits;
    private List<UnitApi> units;
}
