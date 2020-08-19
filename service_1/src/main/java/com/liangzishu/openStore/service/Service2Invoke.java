package com.liangzishu.openStore.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-2")
public interface Service2Invoke {
    @GetMapping("/getService2Data")
    String getService2Data();
}
