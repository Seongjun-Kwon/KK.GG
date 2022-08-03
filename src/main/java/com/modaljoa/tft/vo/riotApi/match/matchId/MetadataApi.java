package com.modaljoa.tft.vo.riotApi.match.matchId;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MetadataApi {
    @JsonProperty(value = "data_version")
    private String dataVersion;

    @JsonProperty(value="match_id")
    private String matchId;
    private List<String> participants;
}