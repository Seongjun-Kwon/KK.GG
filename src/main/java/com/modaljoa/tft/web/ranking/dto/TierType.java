package com.modaljoa.tft.web.ranking.dto;

public enum TierType {
    challenger("챌린저"), grandmaster("그랜드마스터"), master("마스터");

    private String type;

    TierType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
