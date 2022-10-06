package com.modaljoa.tft.web.summoner.api;

import lombok.Data;

@Data
public class MiniSeriesApi {
    private int losses;
    private String progress;
    private int target;
    private int wins;
}
