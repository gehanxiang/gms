package com.gms.feign.Controller;

import com.gms.feign.Service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("feign/ack")
    public String findByIdFeign() {
        String res = userFeignClient.findByIdFeign();
        return res;
    }
}
