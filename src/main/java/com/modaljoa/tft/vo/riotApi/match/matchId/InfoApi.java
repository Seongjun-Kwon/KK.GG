package com.modaljoa.tft.vo.riotApi.match.matchId;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class InfoApi {
    @JsonProperty(value = "game_datetime")
    private long gameDatetime;

    @JsonProperty(value = "game_length")
    private float gameLength;

    @JsonProperty(value = "game_variation")
    private String gameVariation;

    @JsonProperty(value = "game_version")
    private String gameVersion;
    private List<ParticipantApi> participants;

    @JsonProperty(value = "queue_id")
    private int queueId;

    @JsonProperty(value = "tft_set_number")
    private int tftSetNumber;
}
