package com.jaysunxl.scaffold.controller;

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

    @RequestMapping("hello")
    public String hello(){
        return "hello,scaffold";
    }

    @RequestMapping("/{param}")
    public String param(@PathVariable("param") String param){
        return param;
    }
}
