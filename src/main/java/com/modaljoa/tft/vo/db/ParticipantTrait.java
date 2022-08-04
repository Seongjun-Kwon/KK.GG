package com.modaljoa.tft.vo.db;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ParticipantTrait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Participant participant;

    private String name;

    @Column(name = "num_units")
    private int numUnits;
    private int style;

    @Column(name = "tier_current")
    private int tierCurrent;

    @Column(name = "tier_total")
    private int tierTotal;
}
