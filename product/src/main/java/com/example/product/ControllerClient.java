package com.example.product;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xxx")
public class ControllerClient {
    @Autowired
    ServerClient serverClient;
    @RequestMapping("/xxx")
    //TODO
    //如果用实现FallbackFactory类的方法做的话 就可以省去这个注解
    @HystrixCommand(fallbackMethod = "defaultMethod")
    public String demo(){
        return serverClient.test();
    }

    public String defaultMethod(){
        return "error";
    }
}
