package com.jaysunxl.scaffold.thread;

import java.util.concurrent.*;

/**
 * @Description
 * @Author JaySunXl
 * @Version 1.0.0
 * @Date 2023/1/9
 */
public class ThreadPoolUtils {

    /**
     * 创建io密集型线程池
     *
     * @return
     */
    public static ExecutorService createPool() {
        int num = Runtime.getRuntime().availableProcessors();
        final int maxSize = num * 2;
        final int coreSize = num;
        final int aliveTime = 60;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(num * 2 * 100);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //拒绝执行处理器
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        //创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(coreSize, maxSize, aliveTime, unit, workQueue, threadFactory, handler);
        return threadPool;
    }

}
