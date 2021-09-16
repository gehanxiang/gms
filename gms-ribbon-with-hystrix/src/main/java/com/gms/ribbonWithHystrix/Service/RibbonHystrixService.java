package com.gms.ribbonWithHystrix.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    @HystrixCommand(fallbackMethod = "fallback")
    public String findById() {
        return restTemplate.getForObject("http://gms-providerUser/ack", String.class);
    }

    public String fallback(){
        RibbonHystrixService.LOGGER.info("异常发生，进入fallback方法。");
        String res = "ribbon fault";
        return res;
    }
}
