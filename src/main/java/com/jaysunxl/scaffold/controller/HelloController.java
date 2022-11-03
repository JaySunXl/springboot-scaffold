package com.jaysunxl.scaffold.controller;

import com.alibaba.fastjson.JSON;
import com.jaysunxl.scaffold.annotation.LogDetail;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Filter;


/**
 * @author JaySunXl
 * @create 2022-09-27
 * @description
 */
@RestController
@RequestMapping("jaysunxl")
public class HelloController {

    @LogDetail(detail = "HELLO",level = 1)
    @RequestMapping("hello")
    public String hello(){
        return "hello,scaffold";
    }

    @RequestMapping("/{param}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String param(@PathVariable("param") String param){
        Session session = new Session();
        Session.Cookie cookie = session.getCookie();
        boolean persistent = session.isPersistent();
        System.out.println(persistent);
        System.out.println(JSON.toJSONString(cookie));
        return param;
    }
}
