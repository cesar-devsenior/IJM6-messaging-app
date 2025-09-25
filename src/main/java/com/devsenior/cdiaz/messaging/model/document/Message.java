package com.devsenior.cdiaz.messaging.model.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Message {

    // id (@Id, String).
    // senderId (String, referencia al ID del usuario emisor).
    // receiverId (String, referencia al ID del usuario receptor).
    // content (String, el texto del mensaje).
    // timestamp (java.time.LocalDateTime o Instant).
    // type (String, ej. "text", "image", "link" - muestren cómo diferentes mensajes
    // pueden tener campos distintos según el tipo, aunque no los implementen
    // todos).
    // status (String, ej. "sent", "read").

    @Id
    private String id;

    private String senderId;

    private String receiverId;

    private String content;

    private LocalDateTime timestamp;

    private Type type;

    private Status status;

    public static enum Type {
        TEXT("text"), IMAGE("image"), LINK("link");

        private String value;

        Type(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        public static Type fromString(String value) {
            return switch(value) {
                case "text" -> TEXT;
                case "image" -> IMAGE;
                case "link" -> LINK;
                default -> TEXT;
            };
        }

    }

    public static enum Status {
        SENT, READ;
    }


}