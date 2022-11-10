package com.jaysunxl.scaffold.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 异步执行的方式1-1 实现Runnable接口
 * @author sunxind
 * @date 2022-11-10
 */
@Slf4j
public class AsyncRunnable implements Runnable{
    @Override
    public void run() {
      log.info("异步执行的方式1-2");
    }
}
