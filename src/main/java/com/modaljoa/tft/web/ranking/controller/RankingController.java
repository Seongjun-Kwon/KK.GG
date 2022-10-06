package com.modaljoa.tft.web.ranking.controller;

import com.modaljoa.tft.web.ranking.dto.PageDTO;
import com.modaljoa.tft.web.ranking.dto.RankingDTO;
import com.modaljoa.tft.web.ranking.dto.RankingItemDTO;
import com.modaljoa.tft.domain.ranking.RankingService;
import com.modaljoa.tft.web.ranking.dto.TierType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/ranking")
@RequiredArgsConstructor
public class RankingController {

    private final RankingService rankingService;

//    @GetMapping("/ranking/{tier}")
//    public RankingDTO getTopTierUsers(@PathVariable String tier) {
//        return rankingService.getTopTierUsers(tier);
//    }

    @GetMapping
    public String getRankingHomePage() {
        return "rankingHome";
    }

    @GetMapping(params = "tier")
    public String getTopTierUsers(@RequestParam String tier, @RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
        RankingDTO rankingDTO = rankingService.getTopTierUsers(tier);
        PageDTO pageDTO = new PageDTO(page, rankingDTO.getEntries().size());
        List<RankingItemDTO> curPageRankingDTO = rankingService.getListPaging(rankingDTO, pageDTO.getStartIdx(), pageDTO.getPageSize());

        model.addAttribute(rankingDTO);
        model.addAttribute("curPageRankingDTO", curPageRankingDTO);
        model.addAttribute(pageDTO);

        return "ranking";
    }

    @ModelAttribute("tierTypes")
    public TierType[] tierTypes() {
        return TierType.values();
    }

//    @GetMapping("/ranking/{tier}/{division}")
//    public List<SummonerLeagueDTO> findLowTierInfo(@PathVariable String tier, @PathVariable String division) {
//        return rankingService.getLowTierUsers(tier, division);
//    }
}
