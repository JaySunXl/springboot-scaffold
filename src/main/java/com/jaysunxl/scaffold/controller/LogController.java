package com.jaysunxl.scaffold.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实时修改日志级别
 * @author sunxind
 * @date 2022-11-02
 */
@RestController
@RequestMapping("logback")
public class LogController {

    @RequestMapping(value = "/root/{level}", method = RequestMethod.GET)
    @ResponseBody
    public String updateRootLogbackLevel(HttpServletRequest request, HttpServletResponse response, @PathVariable("level") String levelName) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.getLogger(Logger.ROOT_LOGGER_NAME).setLevel(Level.toLevel(levelName));
        return "修改root的logback{" + levelName + "}级别成功";
    }

    @RequestMapping(value = "/{package}/{level}", method = RequestMethod.GET)
    @ResponseBody
    public String updateLogbackLevel(HttpServletRequest request, HttpServletResponse response, @PathVariable("package") String packageName,
                                     @PathVariable("level") String levelName) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.getLogger(packageName).setLevel(Level.toLevel(levelName));
        return "修改package{" + packageName + "}的logback{" + levelName + "}级别成功";
    }

}
