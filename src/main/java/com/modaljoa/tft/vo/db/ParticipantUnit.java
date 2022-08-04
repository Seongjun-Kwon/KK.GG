package com.modaljoa.tft.vo.db;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ParticipantUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Participant participant;

//    private List<Integer> items;

    @Column(name = "character_id")
    private String characterId;
    private String chosen;
    private String name;
    private int rarity;
    private int tier;
}
