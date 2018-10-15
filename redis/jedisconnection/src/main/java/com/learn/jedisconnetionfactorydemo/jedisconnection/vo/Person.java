package com.learn.jedisconnetionfactorydemo.jedisconnection.vo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Person
 * @Description TODO
 * @Author lijiabin
 * @Date 2018/10/15 19:15
 **/

@Data
public class Person {
    private String name;
    private Date createTime;
    private int age;
}
