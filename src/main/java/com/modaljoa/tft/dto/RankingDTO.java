package com.modaljoa.tft.dto;

import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueItem;
import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueList;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RankingDTO {

    private String tier;
    private List<RankingItemDTO> entries;

    public RankingDTO(LeagueList leagueList) {
        this.tier = leagueList.getTier();
        this.entries = getRankingItemDtoList(leagueList.getEntries());
    }

    public List<RankingItemDTO> getRankingItemDtoList(List<LeagueItem> leagueItems) {
        List<RankingItemDTO> rankingItemDtoList = new ArrayList<>();

        for (LeagueItem leagueItem : leagueItems) {
            RankingItemDTO rankingItemDTO = new RankingItemDTO(leagueItem);

            rankingItemDtoList.add(rankingItemDTO);
        }

        return rankingItemDtoList;
    }
}
