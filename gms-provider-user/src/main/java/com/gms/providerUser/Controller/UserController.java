package com.gms.providerUser.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/ack")
    public String findById() {
        return "hello world!";
    }
}
