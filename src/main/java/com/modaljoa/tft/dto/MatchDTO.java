package com.modaljoa.tft.dto;

import com.modaljoa.tft.vo.riotApi.match.matchId.MatchApi;
import com.modaljoa.tft.vo.riotApi.match.matchId.ParticipantApi;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatchDTO {
    private List<ParticipantDTO> participants;
    private long gameDatetime;
    private float gameLength;

    public MatchDTO(MatchApi match) {
        this.participants = getParticipantDtoList(match.getInfo().getParticipants());
        this.gameDatetime = match.getInfo().getGameDatetime();
        this.gameLength = match.getInfo().getGameLength();
    }

    public List<ParticipantDTO> getParticipantDtoList(List<ParticipantApi> participants) {
        List<ParticipantDTO> participantDtoList = new ArrayList<>();

        for (ParticipantApi participant : participants) {
            ParticipantDTO participantDTO = new ParticipantDTO(participant);
            participantDtoList.add(participantDTO);
        }

        return participantDtoList;
    }
}
