package com.example.boot_mongodb.dto;

import lombok.Data;

@Data
public class Message {

    private RestStatus status;
    private String message;
    private Object data;

    public Message() {
        this.status = RestStatus.BadRequest;
        this.data = null;
        this.message = null;
    }
}

