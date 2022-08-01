package com.modaljoa.tft.vo.db;

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

    private String dataVersion;
    private String matchId;
    private Long gameDatetime;
    private Float gameLength;
    private String gameVersion;
    private int queueId;
    private String gameVariation;
    private int tftSetNumber;
}
