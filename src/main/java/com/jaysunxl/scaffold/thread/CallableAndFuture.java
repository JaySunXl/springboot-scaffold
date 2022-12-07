package com.jaysunxl.scaffold.thread;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 通过Future 异步执行任务 future通过get方法阻塞等待异步获取执行的运行结果，性能比较差
 *
 * @author JaySunXl
 * @date 2022-11-10
 */
@Slf4j
public class CallableAndFuture {
    public static ExecutorService executorService = new ThreadPoolExecutor(4, 40,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> future = executorService.submit(new AsyncCallable());
        boolean done = future.isDone();
        if (!done) {
            //任务未完成，取消任务
            boolean cancel = future.cancel(true);
            if (cancel) {
                log.info("成功取消任务");
            } else {
                boolean cancelled = future.isCancelled();
                log.info("cancelled:" + cancelled);
            }
            log.info("任务取消。。。");
        } else {
            String s = future.get();//此时会阻塞主线程
            log.info(s);
        }
        executorService.shutdown();
    }
}
