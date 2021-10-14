package com.gms.providerUser.Controller;

import com.gms.providerUser.Retention.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {

    @GetMapping("/ack")
    @Limit(key = "limit1", permitsPerSecond = 1, timeout = 500, timeunit = TimeUnit.MILLISECONDS,msg = "当前排队人数较多，请稍后再试！")
    public String findById() {

        return "hello world!";
    }
}
