package com.example.chat.entiy;



import lombok.Data;


/**
 * @Author: Han
 * @Date: 2024
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/

@Data
public class User {

    private String user_id;
    private String avatar;
    private String user_name;
    private String password;
    private String salt;
    private String email;
    private String phone;
    private String sex;
    private int age;
    private int status;


}

