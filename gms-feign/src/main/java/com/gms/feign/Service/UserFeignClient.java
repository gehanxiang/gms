package com.gms.feign.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "gms-providerUser")
public interface UserFeignClient {
    @RequestMapping("/ack")
    public String findByIdFeign();
}
