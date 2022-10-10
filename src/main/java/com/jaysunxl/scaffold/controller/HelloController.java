package com.jaysunxl.scaffold.controller;

import com.jaysunxl.scaffold.annotation.LogDetail;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String param(@PathVariable("param") String param){
        return param;
    }
}
