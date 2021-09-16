package com.gms.ribbon.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public String findById() {
        return this.restTemplate.getForObject("http://gms-providerUser/ack",String.class);
    }
}
