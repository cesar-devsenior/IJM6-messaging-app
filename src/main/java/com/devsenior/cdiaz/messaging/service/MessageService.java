package com.devsenior.cdiaz.messaging.service;

import java.util.List;

import com.devsenior.cdiaz.messaging.model.dto.MessageRequest;
import com.devsenior.cdiaz.messaging.model.dto.MessageResponse;

public interface MessageService {
    List<MessageResponse> getMessages(String receiver, String sender);
    void sendMessage(MessageRequest request);
}
