package com.modaljoa.tft.repository;

import com.modaljoa.tft.vo.db.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
