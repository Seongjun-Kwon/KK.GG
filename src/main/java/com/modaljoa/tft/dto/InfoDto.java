package com.modaljoa.tft.dto;

import lombok.Data;

import java.util.List;

@Data
public class InfoDto {
    private long game_datetime;
    private float game_length;
    private String game_variation;
    private String game_version;
    private List<ParticipantDto> participants;
    private int queue_id;
    private int tft_set_number;
}
