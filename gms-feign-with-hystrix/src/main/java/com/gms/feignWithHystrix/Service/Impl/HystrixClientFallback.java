package com.gms.feignWithHystrix.Service.Impl;

import com.gms.feignWithHystrix.Service.UserFeignWithHystrixClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignWithHystrixClient {

    private static final Logger LOGGER = LoggerFactory.getLogger (HystrixClientFallback.class);

    @Override
    public String findByIdFeignWithHystrix(){
        HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法。");
        String res = "feign fault";
        return res;
    }
}
