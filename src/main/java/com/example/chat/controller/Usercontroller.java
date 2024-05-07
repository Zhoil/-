package com.example.chat.controller;

import com.example.chat.entiy.LoginRequest;
import com.example.chat.entiy.RegisterRequest;
import com.example.chat.entiy.User;
import com.example.chat.mapper.Userdao;
import com.example.chat.upper.Usermapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class Usercontroller {

//    @Autowired
//    private Usercon usercon;

//    @Operation(summary = "获取name")
//    @GetMapping("/user/{id}")
//    public String getUserById(@PathVariable String name) {
//        System.out.println(name);
//        return name;
//    }

    @Autowired
    private Usermapper usermapper;

    @GetMapping("/uu")
    public String get(){

        List<User> users = usermapper.getUsers();
        System.out.println(users);
        return "Search";
    }

    @Operation(summary = "查询用户")
    @GetMapping("/api/login/{name}")
    public ResponseEntity<User> query(@PathVariable String name) throws Exception {
        User user = usermapper.getUser(name);
        if(user!=null) return ResponseEntity.status(200).body(user);
        else return ResponseEntity.status(404).body(null);
    }

    @Operation(summary = "发送请求，验证登陆")
    @PostMapping("/api/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        // 在这里处理登录逻辑，可以访问request中的username和password
        // 比如验证用户信息，生成并返回token等操作
        User user = usermapper.getUser(request.getUsername());
        System.out.println(user);
        if(user!=null) return ResponseEntity.status(200).body(user);
        else return ResponseEntity.status(404).body(null);
    }

    @Operation(summary = "发送注册请求")
    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        // 在这里处理注册逻辑，可以访问request中的username、email和password等信息
        // 比如保存用户信息到数据库等操作
        return ResponseEntity.ok("Registration successful");
    }

    @GetMapping("/api/register")
    public String testRegister() {
        return "Register 请求\n"+"It's OK.";
    }

}
