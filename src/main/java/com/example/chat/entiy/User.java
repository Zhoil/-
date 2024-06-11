package com.example.chat.entiy;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author: Han
 * @Date: 2024
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/

@Data
public class User {

    private String userId;
    private String avatar;
    private String userName;
    private String password;
    private String salt;
    private String email;
    private String phone;
    private String sex;
    private Integer age;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}

