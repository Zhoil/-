package com.example.chat.controller;

import com.example.chat.entiy.LoginRequest;
import com.example.chat.entiy.RegisterRequest;
import com.example.chat.entiy.User;
import com.example.chat.upper.Usermapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class Usercontroller {


    private int id = 2;

    @Autowired
    private Usermapper usermapper;

    @GetMapping("/uu")
    public String get(){

        List<User> users = usermapper.getUsers();
        System.out.println(users);
        return "Search";
    }

    @Operation(summary = "发送好友请求")
    @GetMapping("/api/add_req")
    public String req(@RequestParam("name") String name) throws Exception {
        User user = usermapper.getUser(name);
        //向指定用户发送好友请求

        if(user!=null) return "OK";
        else return "NO";
    }

    @Operation(summary = "查询用户")
    @GetMapping("/api/user/searchUserByUserName")
    public String query(String name) throws Exception {
        User user = usermapper.getUser(name);
        if(user!=null) return "OK";
        else return "NO";
    }

    @Operation(summary = "发送请求，验证登陆")
    @PostMapping("/api/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        // 在这里处理登录逻辑，可以访问request中的username和password
        // 比如验证用户信息，生成并返回token等操作
        User user = usermapper.getUser(request.getUsername());
        System.out.println(user);
        if(user==null) return ResponseEntity.status(404).body(null);
        if( user.getPassword().equals(request.getPassword()) ) return ResponseEntity.status(200).body(user);
        else return ResponseEntity.status(404).body(null);
    }

    @Operation(summary = "发送注册请求")
    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        // 在这里处理注册逻辑，可以访问request中的username、email和password等信息
        // 比如保存用户信息到数据库等操作
        User user = usermapper.getUser(request.getUsername());
        if(user==null) {
            User userin = new User();
            userin.setUserId(String.valueOf(id++));
            userin.setUserName(request.getUsername());
            userin.setEmail(request.getEmail());
            userin.setPassword(request.getPassword());
            int i = usermapper.insertUser(userin);
            if(i > 0) return ResponseEntity.ok("Registration successful");
            else return ResponseEntity.status(404).body("Registration failed");
        }
        return ResponseEntity.status(404).body("Registration failed");
    }


}
