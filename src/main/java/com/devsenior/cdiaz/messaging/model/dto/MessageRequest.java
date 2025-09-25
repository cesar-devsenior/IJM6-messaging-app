package com.devsenior.cdiaz.messaging.model.dto;

import lombok.Data;

@Data
public class MessageRequest {
    private String senderId;

    private String receiverId;

    private String content;

    private String type;
}
