package com.example.chat.controller;

import com.example.chat.entiy.LoginRequest;
import com.example.chat.entiy.RegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class Usercontroller {

    @Operation(summary = "获取ID")
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        System.out.println(id);
        return "Hello World";
    }

    @GetMapping("/api/login")
    public String testGet() {
        return "GET 请求";
    }
//
//    @Operation(summary = "Try")
//    @PostMapping("/api/login")
//    public String testPost() {
//        return "YES";
//    }
    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // 在这里处理登录逻辑，可以访问request中的username和password
        // 比如验证用户信息，生成并返回token等操作
        return ResponseEntity.ok("Login successful");
    }

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
