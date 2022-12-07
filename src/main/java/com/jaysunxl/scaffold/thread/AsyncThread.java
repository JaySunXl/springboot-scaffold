package com.jaysunxl.scaffold.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 异步执行的方式1-1 直接继承Thread类
 *
 * @author JaySunXl
 * @date 2022-11-10
 */
@Slf4j
public class AsyncThread extends Thread {

    @Override
    public void run() {
        log.info("异步执行的方式1-1");
    }
}
