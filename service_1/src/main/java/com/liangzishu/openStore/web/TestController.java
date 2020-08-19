package com.liangzishu.openStore.web;

import com.liangzishu.openStore.service.Service2Invoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private Service2Invoke service2Invoke;
    @GetMapping("hello")
    public String hello(){
        String service2Data = service2Invoke.getService2Data();
        return "service1data--------"+service2Data;
    }
}
