package com.example.chat.controller;


import com.example.chat.entiy.Imsingle;
import com.example.chat.entiy.User;
import com.example.chat.entiy.unReadMessage;
import com.example.chat.service.SingleService;
import com.example.chat.upper.Usermapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Single")
@CrossOrigin
public class SingleController {

    @Resource
    private SingleService serverSingleService;

    @Operation(summary = "查找消息记录")
    @GetMapping
    public ResponseEntity<List<Imsingle>> findByFromUser(@RequestParam("fromUser") String from_user, @RequestParam("toUser") String to_user) {
        List<Imsingle> all = serverSingleService.findByUsername(from_user,to_user);
        return ResponseEntity.status(200).body(all);
    }

    @Operation(summary = "查找未读消息记录")
    @GetMapping("/unReadNums")
    public ResponseEntity<List<unReadMessage>> findByToUser(@RequestParam("fromUser") String from_user,@RequestParam("toUser") String to_user) {
        List<unReadMessage> unReads = serverSingleService.findUnReadNums(from_user,to_user);
        return ResponseEntity.status(200).body(unReads);
    }

}
