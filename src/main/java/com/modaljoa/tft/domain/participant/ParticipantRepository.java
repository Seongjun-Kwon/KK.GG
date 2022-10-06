package com.modaljoa.tft.domain.participant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findByPuuid(String puuid);
}
