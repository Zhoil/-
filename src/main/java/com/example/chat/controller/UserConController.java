package com.example.chat.controller;


import com.example.chat.entiy.Friends;
import com.example.chat.entiy.User;
import com.example.chat.upper.Usermapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/apd")
@CrossOrigin
public class UserConController {

    @Autowired
    private Usermapper usermapper;

    @Operation(summary = "ID->Name")
    @PostMapping("/link")
    public User login(@RequestParam("login_userid") String login_userid) {
        return usermapper.getUser_in(login_userid);
    }

    @Operation(summary = "ID->friends")
    @PostMapping("/link/friends")
    public ResponseEntity<List<Friends>> findFriend(@RequestParam("id") String id) {
        List<Friends> all = new ArrayList<Friends>();
        List<String> friends = usermapper.getUsers_in_relationship(id);
        friends.forEach(item->{
            all.add(usermapper.getUsers_friends_relationship(item));
        });
        return ResponseEntity.status(200).body(all);
    }

}
