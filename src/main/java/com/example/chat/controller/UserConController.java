package com.example.chat.controller;


import com.example.chat.upper.Usermapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/apd/link")
@CrossOrigin
public class UserConController {

    @Autowired
    private Usermapper usermapper;

    @Operation(summary = "ID->Name")
    @PostMapping()
    public String login(@RequestParam("login_userid") String login_userid) {
        return usermapper.getUserName(login_userid);
    }
}
