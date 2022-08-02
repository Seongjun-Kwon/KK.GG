package com.modaljoa.tft.dto;

import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueItemApi;
import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueListApi;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RankingDTO {

    private String tier;
    private List<RankingItemDTO> entries;

    public RankingDTO(LeagueListApi leagueList) {
        this.tier = leagueList.getTier();
        this.entries = getRankingItemDtoList(leagueList.getEntries());
    }

    public List<RankingItemDTO> getRankingItemDtoList(List<LeagueItemApi> leagueItems) {
        List<RankingItemDTO> rankingItemDtoList = new ArrayList<>();

        for (LeagueItemApi leagueItem : leagueItems) {
            RankingItemDTO rankingItemDTO = new RankingItemDTO(leagueItem);

            rankingItemDtoList.add(rankingItemDTO);
        }

        return rankingItemDtoList;
    }
}
