package com.example.product;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eurekatest"/*,fallbackFactory = DeptClientServiceFallbackFactory.class*/)
public interface ServerClient {
    @RequestMapping("/text/msg")
    String test();

}
