package com.gms.ribbonWithHystrix.Controller;

import com.gms.ribbonWithHystrix.Service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonHystrixController {

    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/ribbon/ack")
    public String findById() {
        return ribbonHystrixService.findById();
    }
}
