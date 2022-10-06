package com.modaljoa.tft.domain.match;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
    Match findByMatchId(String matchId);
}
