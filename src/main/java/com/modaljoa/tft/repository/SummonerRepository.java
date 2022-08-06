package com.modaljoa.tft.repository;

import com.modaljoa.tft.vo.db.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonerRepository extends JpaRepository<Summoner, Long> {
    Summoner findByName(String name);
}
