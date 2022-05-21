package com.modaljoa.tft.dto;

import com.modaljoa.tft.vo.riotApi.match.matchId.Match;
import com.modaljoa.tft.vo.riotApi.match.matchId.Participant;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatchDTO {
    private List<ParticipantDTO> participants;
    private long gameDatetime;
    private float gameLength;

    public MatchDTO(Match match) {
        this.participants = getParticipantDtoList(match.getInfo().getParticipants());
        this.gameDatetime = match.getInfo().getGameDatetime();
        this.gameLength = match.getInfo().getGameLength();
    }

    public List<ParticipantDTO> getParticipantDtoList(List<Participant> participants) {
        List<ParticipantDTO> participantDtoList = new ArrayList<>();

        for (Participant participant : participants) {
            ParticipantDTO participantDTO = new ParticipantDTO(participant);
            participantDtoList.add(participantDTO);
        }

        return participantDtoList;
    }
}
