package com.example.feign.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ApiController
 * @Description TODO
 * @Author lijiabin
 * @Date 2018/9/18 20:13
 **/
@RestController
@RequestMapping(value = "/apiserver")
public class ApiController {

    @GetMapping(value = "/hi")
    public String sayHi(){
        return "hi,"+ System.currentTimeMillis();
    }
}
