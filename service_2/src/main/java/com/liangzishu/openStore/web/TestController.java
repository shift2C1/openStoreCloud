package com.liangzishu.openStore.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("getService2Data")
    public String getService2Data(){
        return "data from service2";
    }
}
