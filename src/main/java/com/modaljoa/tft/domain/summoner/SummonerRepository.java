package com.modaljoa.tft.domain.summoner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonerRepository extends JpaRepository<Summoner, Long> {
    Summoner findByName(String name);
}
