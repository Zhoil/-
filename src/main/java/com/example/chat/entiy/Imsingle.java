package com.example.chat.entiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class Imsingle {
    String handle;
    String send_user;
    String receive_user;
    String content;
    int is_read;


}
