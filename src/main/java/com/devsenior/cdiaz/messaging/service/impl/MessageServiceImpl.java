package com.devsenior.cdiaz.messaging.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.cdiaz.messaging.model.document.Message;
import com.devsenior.cdiaz.messaging.model.dto.MessageRequest;
import com.devsenior.cdiaz.messaging.model.dto.MessageResponse;
import com.devsenior.cdiaz.messaging.repository.MessageRepository;
import com.devsenior.cdiaz.messaging.service.MessageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final DateTimeFormatter dateTimeFormatter;

    @Override
    public List<MessageResponse> getMessages(String receiver, String sender) {
        return messageRepository.findAllBetweenReceiverAndSender(receiver, sender).stream()
                .map(m -> {
                    var response = new MessageResponse();
                    response.setContent(m.getContent());
                    response.setTimestamp(dateTimeFormatter.format(m.getTimestamp()));
                    response.setType(m.getType().toString());
                    response.setStatus(m.getStatus().toString());
                    return response;
                })
                .toList();

        // return
        // messageRepository.findAllByReceiverIdAndSenderIdOrderByTimestamp(receiver,
        // sender).stream()
        // .map(m -> {
        // var response = new MessageResponse();
        // response.setContent(m.getContent());
        // response.setTimestamp(dateTimeFormatter.format(m.getTimestamp()));
        // response.setType(m.getType().toString());
        // response.setStatus(m.getStatus().toString());
        // return response;
        // })
        // .toList();
    }

    @Override
    public void sendMessage(MessageRequest request) {
        // TODO Validar campos del mensaje

        var document = new Message();
        document.setSenderId(request.getSenderId());
        document.setReceiverId(request.getReceiverId());
        document.setContent(request.getContent());
        document.setTimestamp(LocalDateTime.now());
        document.setType(Message.Type.fromString(request.getType()));
        document.setStatus(Message.Status.SENT);

        messageRepository.save(document);
    }

}
