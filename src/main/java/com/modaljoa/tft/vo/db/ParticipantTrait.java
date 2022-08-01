package com.modaljoa.tft.vo.db;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ParticipantTrait {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Participant participant;

    private String name;
    private int numUnits;
    private int style;
    private int tierCurrent;
    private int tierTotal;
}
