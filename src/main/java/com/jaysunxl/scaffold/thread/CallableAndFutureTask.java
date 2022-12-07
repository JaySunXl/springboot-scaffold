package com.jaysunxl.scaffold.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 通过FutureTask异步执行任务
 * @author JaySunXl
 * @date 2022-11-10
 */
@Slf4j
public class CallableAndFutureTask {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new AsyncCallable());
        FutureTask<String> task2 = new FutureTask<>(new AsyncCallable());
        FutureTask<String> task3 = new FutureTask<>(new AsyncCallable());
        executorService.submit(task);
        executorService.submit(task2);
        executorService.submit(task2);
        try {
            String s = task.get();
            String s1 = task2.get();
            String s2 = task3.get();
            log.info(s);
        } catch (Exception e) {
            log.error("执行异步任务时报错：",e);
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }

    }

}
