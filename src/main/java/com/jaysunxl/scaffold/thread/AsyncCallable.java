package com.jaysunxl.scaffold.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * 异步执行的方式1-3 实现CallAble接口
 *
 * @author JaySunXl
 * @date 2022-11-10
 */
@Slf4j
public class AsyncCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            log.info("异步执行的方式1-3");
            int i = 1 / 0;
            return "异步执行的方式1-3";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
