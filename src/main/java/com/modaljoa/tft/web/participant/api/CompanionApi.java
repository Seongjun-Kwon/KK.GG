package com.modaljoa.tft.web.participant.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class CompanionApi { // 꼬마 전설이

    @JsonProperty(value = "content_ID")
    private String contentId;

    @JsonProperty(value="skin_ID")
    private int skinId;
    private String species;
}
