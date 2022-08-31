package com.modaljoa.tft.controller;

import com.modaljoa.tft.dto.RankingDTO;
import com.modaljoa.tft.service.RankingService;
import com.modaljoa.tft.vo.domain.TierType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String getTopTierUsers(@RequestParam String tier, Model model) {
        RankingDTO rankingDTO = rankingService.getTopTierUsers(tier);
        model.addAttribute(rankingDTO);

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
