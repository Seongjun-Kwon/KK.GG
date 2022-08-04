package com.modaljoa.tft.vo.db;

import com.modaljoa.tft.vo.riotApi.match.matchId.MatchApi;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
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

    public Match() {
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
