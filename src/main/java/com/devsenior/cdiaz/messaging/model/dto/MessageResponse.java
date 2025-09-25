package com.devsenior.cdiaz.messaging.model.dto;

import lombok.Data;

@Data
public class MessageResponse {
    private String content;

    private String timestamp;

    private String type;

    private String status;
}
