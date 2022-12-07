package com.jaysunxl.scaffold.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author JaySunXl
 * @date 2022-11-17
 */
public class CountCallable implements Callable<String> {
    private CountDownLatch count;

    public CountCallable(CountDownLatch count) {
        this.count = count;
    }

    @Override
    public String call() throws Exception {
        count.countDown();
        return Thread.currentThread().getName() + "使用计数器完成";
    }


    public static void main(String[] args) {
        //1.定义线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //2.定义计数器
        CountDownLatch count = new CountDownLatch(5);
        //3.提交线程操作
        for (int i = 0; i < 5; i++) {
            Future<String> submit = executor.submit(new CountCallable(count));
            String s = null;
            try {
                s = submit.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                System.out.println(s);
            }
        }
        //4.释放线程池资源
        executor.shutdown();
        //5.输出日志
        System.out.println("多线程操作完成");
    }
}
