package com.modaljoa.tft.vo.db;

import com.modaljoa.tft.vo.riotApi.match.matchId.Companion;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "summoner_id")
    private Summoner summoner;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @Embedded
    private Companion companion;

    private int goldLeft;
    private int lastRound;
    private int level;
    private int placement;
    private int playersEliminated;
    private String puuid;
    private float timeEliminated;
    private int totalDamageToPlayers;

    @OneToMany(mappedBy = "participant")
    private List<ParticipantTrait> traits;

    @OneToMany(mappedBy = "participant")
    private List<ParticipantUnit> units;
}
