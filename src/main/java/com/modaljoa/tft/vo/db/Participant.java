package com.modaljoa.tft.vo.db;

import com.modaljoa.tft.vo.riotApi.match.matchId.CompanionApi;
import com.modaljoa.tft.vo.riotApi.match.matchId.ParticipantApi;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
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
    private CompanionApi companion;

    @Column(name = "gold_left")
    private int goldLeft;

    @Column(name = "last_round")
    private int lastRound;
    private int level;
    private int placement;

    @Column(name = "players_eliminated")
    private int playersEliminated;
    private String puuid;

    @Column(name = "time_eliminated")
    private float timeEliminated;

    @Column(name = "total_damage_to_players")
    private int totalDamageToPlayers;

    @OneToMany(mappedBy = "participant")
    private List<ParticipantTrait> traits;

    @OneToMany(mappedBy = "participant")
    private List<ParticipantUnit> units;

    protected Participant() {
    }

    public Participant(Summoner summonerDb, Match matchDb, ParticipantApi participantApi) {
        this.summoner = summonerDb;
        this.match = matchDb;
        this.companion = participantApi.getCompanion();
        this.goldLeft = participantApi.getGoldLeft();
        this.lastRound = participantApi.getLastRound();
        this.level = participantApi.getLevel();
        this.placement = participantApi.getPlacement();
        this.playersEliminated = participantApi.getPlayersEliminated();
        this.puuid = participantApi.getPuuid();
        this.timeEliminated = participantApi.getTimeEliminated();
        this.totalDamageToPlayers = participantApi.getTotalDamageToPlayers();
    }
}
