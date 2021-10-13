package com.gms.providerUser.Controller;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {

    private final RateLimiter limiter = RateLimiter.create(2.0);

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/ack")
    public String findById() {

        boolean tryAcquire = limiter.tryAcquire(500, TimeUnit.MILLISECONDS);

        if (!tryAcquire) {
            return "当前排队人数较多，请稍后再试！";
        }

        return "hello world!";
    }
}
