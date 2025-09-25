package com.devsenior.cdiaz.messaging.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.devsenior.cdiaz.messaging.model.document.Message;

public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findAllByReceiverIdAndSenderIdOrderByTimestamp(String receiverId, String senderId);

    @Query("db.message.find({ $or: [ { receiverId: :receiver, senderId: :sender }, {receiverId: :sender, senderId: :receiver} ] })")
    List<Message> findAllBetweenReceiverAndSender(String receiver, String sender);
    
}
