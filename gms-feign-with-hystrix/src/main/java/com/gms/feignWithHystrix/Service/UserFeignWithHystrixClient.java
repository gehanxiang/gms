package com.gms.feignWithHystrix.Service;

import com.gms.feignWithHystrix.Service.Impl.HystrixClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "gms-providerUser", fallback = HystrixClientFallback.class)
@Service
public interface UserFeignWithHystrixClient {
    @RequestMapping("/ack")
    public String findByIdFeignWithHystrix();
}
