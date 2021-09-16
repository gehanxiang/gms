package com.gms.feignWithHystrix.Controller;

import com.gms.feignWithHystrix.Service.UserFeignWithHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHystrixController {

    @Autowired
    private UserFeignWithHystrixClient userFeignWithHystrixClient;

    @GetMapping("feign/ack")
    public String findByIdFeignWithHystrix() {
        String res = userFeignWithHystrixClient.findByIdFeignWithHystrix();
        return res;
    }

}
