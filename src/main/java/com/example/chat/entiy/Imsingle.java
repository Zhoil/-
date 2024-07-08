package com.example.chat.entiy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
@Table(name = "message")
public class Imsingle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "handle")
    private String handle;

    @Column(name = "send_user")
    private String send_user;

    @Column(name = "receive_user")
    private String receive_user;

    @Column(name = "content")
    private String content;

    @Column(name = "is_read")
    private int is_read;


}
