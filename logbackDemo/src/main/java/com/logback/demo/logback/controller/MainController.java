package com.logback.demo.logback.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName MainController
 * @Description TODO
 * @Author lijiabin
 * @Date 2018/10/10 00:30
 **/
@Slf4j
@RestController
@RequestMapping(value = "/logback")
public class MainController {

    @GetMapping(value = "/hi/{name}")
    public ResponseEntity<JSONObject> sayHi(@PathVariable("name") String name){
        JSONObject result = new JSONObject();
        result.put("hello" ,name);
        result.put("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        log.debug("debug --> {}",result);
        log.info("info --> {}",result);
        log.warn("warn --> {}",result);
        log.error("error --> {}",result);

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
