package com.example.chat.entiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;


@Getter
@Setter
@ToString
public class unReadMessage {
    private String handle;
    private String send_user;
    private String receive_user;
    private String content;
    private int is_read;

}

