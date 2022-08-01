package com.modaljoa.tft.repository;

import com.modaljoa.tft.vo.db.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
