package com.example.feignclient.feignclient.controller;

import com.example.feignclient.feignclient.HttpServer.HttpApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName mainController
 * @Description TODO
 * @Author lijiabin
 * @Date 2018/9/18 20:24
 **/
@RestController
@RequestMapping(value = "/client")
public class mainController {

    @Autowired
    private HttpApi httpApi;

    @GetMapping(value = "hiserver")
    public String sayHi(){
        return "--->"+httpApi.sayHi();
    }
}
