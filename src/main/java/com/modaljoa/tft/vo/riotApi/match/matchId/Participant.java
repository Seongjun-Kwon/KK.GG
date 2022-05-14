package com.modaljoa.tft.vo.riotApi.match.matchId;

import lombok.Data;

import java.util.List;

@Data
public class Participant {
    private int goldLeft;
    private int lastRound;
    private int level;
    private int placement;
    private int playersEliminated;
    private String puuid;
    private float timeEliminated;
    private int totalDamageToPlayers;
    private List<Trait> traits;
    private List<Unit> units;
}
