package com.example.bopleopenviduclientsessiontoken.model.audiochat;

import lombok.Data;

@Data
public class AudioChatEntryDto {
    private Long roomId;
    private String memberName;
    private AudioChatRole role;
    private Long participantCount;
}
