package com.learn.jedisconnetionfactorydemo.jedisconnection.controller;

import com.alibaba.fastjson.JSONObject;
import com.learn.jedisconnetionfactorydemo.jedisconnection.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MainController
 * @Description TODO
 * @Author lijiabin
 * @Date 2018/10/15 19:00
 **/
@RestController
@RequestMapping(value = "/redis")
public class MainController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/set/{key}")
    public ResponseEntity<JSONObject> setCache(@PathVariable(value = "key") String key){

        Person p = genPerson(key);

        //cache person 30s secondes
        redisTemplate.opsForValue().set(key,p,30, TimeUnit.SECONDS);

        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(p));
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{key}")
    public ResponseEntity<JSONObject> getCache(@PathVariable(value = "key") String key){

        Person value = (Person) redisTemplate.opsForValue().get(key);

        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(value));
        return new ResponseEntity(result, HttpStatus.OK);
    }

    private Person genPerson(@PathVariable(value = "key") String key) {
        Person p = new Person();
        p.setName(key);
        p.setAge((int)(Math.random() * 100));
        p.setCreateTime(new Date(System.currentTimeMillis()));
        return p;
    }
}
