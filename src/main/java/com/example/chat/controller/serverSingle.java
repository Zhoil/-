package com.example.chat.controller;

import com.example.chat.entiy.Imsingle;
import com.example.chat.service.SingleService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Single")
public class serverSingle {

    @Resource
    private SingleService serverSingleService;

    /**
     * 查看所有信息
     */
    @GetMapping
    public ResponseEntity<List<Imsingle>> findByFromUsername(@RequestParam String fromUser, @RequestParam String toUser) {
        List<Imsingle> all = serverSingleService.findByUsername(fromUser,toUser);
        return ResponseEntity.status(200).body(all);
    }

    @GetMapping("/unReadNums")
    public int findUnReadNums(@RequestParam String fromUser, @RequestParam String toUser) {
        return serverSingleService.findUnReadNums(fromUser,toUser);
    }

}
