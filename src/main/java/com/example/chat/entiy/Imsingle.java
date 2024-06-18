package com.example.chat.entiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Imsingle {
    String send_user;
    String receive_user;
    String content;
    int is_read;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime create_time;

}
