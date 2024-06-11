package com.example.chat.entiy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class Message {

    private String handle;

    private String sendUser;

    private String receiveUser;

    private String content;

    private String isRead;

    private LocalDateTime createTime;
}

