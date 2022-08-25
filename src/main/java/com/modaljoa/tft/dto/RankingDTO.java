package com.modaljoa.tft.dto;

import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueItemApi;
import com.modaljoa.tft.vo.riotApi.league.topTierUser.LeagueListApi;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        Collections.sort(rankingItemDtoList, new Comparator<RankingItemDTO>() {
            @Override
            public int compare(RankingItemDTO o1, RankingItemDTO o2) {
                if (o1.getLeaguePoints() > o2.getLeaguePoints()) {
                    return -1;
                } else if (o1.getLeaguePoints() == o2.getLeaguePoints()) {
                    if (o1.getWins() > o2.getWins()) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });

        return rankingItemDtoList;
    }
}
