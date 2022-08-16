package com.modaljoa.tft.vo.db;

import com.modaljoa.tft.dto.SummonerLeagueDTO;
import com.modaljoa.tft.vo.riotApi.summoner.summonerName.SummonerApi;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
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

    protected Summoner() {
    }

    public Summoner(SummonerApi summonerApi, SummonerLeagueDTO summonerLeagueDTO) {
        this.summonerId = summonerApi.getId();
        this.name = summonerApi.getName();
        this.profileIconId = summonerApi.getProfileIconId();
        this.summonerLevel = summonerApi.getSummonerLevel();
        this.tier = summonerLeagueDTO.getTier();
        this.rank = summonerLeagueDTO.getRank();
        this.leaguePoints = summonerLeagueDTO.getLeaguePoints();
        this.wins = summonerLeagueDTO.getWins();
        this.losses = summonerLeagueDTO.getLosses();
    }

    public void updateSummoner(SummonerApi summonerApi, SummonerLeagueDTO summonerLeagueDTO) {
        this.name = summonerApi.getName();
        this.profileIconId = summonerApi.getProfileIconId();
        this.summonerLevel = summonerApi.getSummonerLevel();
        this.tier = summonerLeagueDTO.getTier();
        this.rank = summonerLeagueDTO.getRank();
        this.leaguePoints = summonerLeagueDTO.getLeaguePoints();
        this.wins = summonerLeagueDTO.getWins();
        this.losses = summonerLeagueDTO.getLosses();
    }

    public boolean isChanged(SummonerApi summonerApi, SummonerLeagueDTO summonerLeagueDTO) {
        if (this.name != summonerApi.getName() ||
                this.profileIconId != summonerApi.getProfileIconId() ||
                this.summonerLevel != summonerApi.getSummonerLevel() ||
                this.tier != summonerLeagueDTO.getTier() ||
                this.rank != summonerLeagueDTO.getRank() ||
                this.leaguePoints != summonerLeagueDTO.getLeaguePoints() ||
                this.wins != summonerLeagueDTO.getWins() ||
                this.losses != summonerLeagueDTO.getLosses()) {
            return true;
        } else {
            return false;
        }
    }
}
