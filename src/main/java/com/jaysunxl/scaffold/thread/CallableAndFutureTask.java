package com.jaysunxl.scaffold.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 通过FutureTask异步执行任务
 * @author sunxind
 * @date 2022-11-10
 */
@Slf4j
public class CallableAndFutureTask {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new AsyncCallable());
        executorService.submit(task);
        try {
            String s = task.get();
            log.info(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }

}
