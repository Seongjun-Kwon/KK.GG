package com.modaljoa.tft.domain.match;

import com.modaljoa.tft.domain.participant.Participant;
import com.modaljoa.tft.web.match.api.MatchApi;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "match")
    private List<Participant> matchParticipant;

    @Column(name = "data_version")
    private String dataVersion;

    @Column(name = "match_id")
    private String matchId;

    @Column(name = "game_datetime")
    private Long gameDatetime;

    @Column(name = "game_length")
    private Float gameLength;

    @Column(name = "game_version")
    private String gameVersion;

    @Column(name = "queue_id")
    private int queueId;

    @Column(name = "game_variation")
    private String gameVariation;

    @Column(name = "tft_set_number")
    private int tftSetNumber;

    protected Match() {
    }

    public Match(MatchApi matchApi) {
        this.dataVersion = matchApi.getMetadata().getDataVersion();
        this.matchId = matchApi.getMetadata().getMatchId();
        this.gameDatetime = matchApi.getInfo().getGameDatetime();
        this.gameLength = matchApi.getInfo().getGameLength();
        this.gameVersion = matchApi.getInfo().getGameVersion();
        this.queueId = matchApi.getInfo().getQueueId();
        this.gameVariation = matchApi.getInfo().getGameVariation();
        this.tftSetNumber = matchApi.getInfo().getTftSetNumber();
    }
}
