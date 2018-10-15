package com.example.feignclient.feignclient.HttpServer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value ="test")
public interface HttpApi {

    @GetMapping(value = "/apiserver/hi")
    String sayHi();
}
