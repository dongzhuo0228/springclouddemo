package com.example.product;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component//不要忘记添加
@Slf4j
public class DeptClientServiceFallbackFactory implements FallbackFactory<ServerClient> {
    @Override
    public ServerClient create(Throwable throwable) {
        return new ServerClient() {
            @Override
            public String test() {
                log.info("该服务已经关闭");
                return "该服务已经关闭";
            }
        };
    }
}