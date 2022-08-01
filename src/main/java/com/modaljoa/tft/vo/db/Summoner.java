package com.modaljoa.tft.vo.db;

import com.modaljoa.tft.dto.SummonerLeagueDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Summoner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 기본 정보
    @Column(name = "summoner_id")
    private String summonerId;
    private String name;

    @Column(name = "profile_icon_id")
    private int profileIconId;

    @Column(name = "summoner_level")
    private long summonerLevel;

    // 리그 정보
    private String tier;
    private String rank;

    @Column(name = "league_points")
    private int leaguePoints;
    private int wins;
    private int losses;

    @OneToMany(mappedBy = "summoner")
    private List<Participant> matchParticipants;

    public Summoner() {
    }

    public Summoner(com.modaljoa.tft.vo.riotApi.summoner.summonerName.Summoner summoner, SummonerLeagueDTO summonerLeagueDTO) {
        this.summonerId = summoner.getId();
        this.name = summoner.getName();
        this.profileIconId = summoner.getProfileIconId();
        this.summonerLevel = summoner.getSummonerLevel();
        this.tier = summonerLeagueDTO.getTier();
        this.rank = summonerLeagueDTO.getRank();
        this.leaguePoints = summonerLeagueDTO.getLeaguePoints();
        this.wins = summonerLeagueDTO.getWins();
        this.losses = summonerLeagueDTO.getLosses();
    }
}
