package com.example.bopleopenviduclientsessiontoken.model.audiochat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AudioChatLeaveDto {
    private Long roomId;
    private String memberName;
    private String role;
    private String token;
}

