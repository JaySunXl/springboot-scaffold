package com.jaysunxl.scaffold.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static cn.hutool.core.thread.ThreadUtil.sleep;


/**
 * jdk1.8提供
 * 通过回调的方式来处理计算结果，实现了异步非阻塞，性能更优。
 * 常用api
 * 1. runAsync/supplyAsync
 * 2. thenApply/thenApplyAsync
 *  1. thenApply 由执行job1的线程立即执行job2，即两个job都是同一个线程执行的
 *  2. thenApplyAsync 将job2提交到线程池中异步执行，实际执行job2的线程可能是另外一个线程
 * 3. thenAccept/thenRun
 *  1. thenAccept 同 thenApply 接收上一个任务的返回值作为参数，但是无返回值；
 *  2. thenRun 方法没有入参，也没有返回值，
 * 4. exceptionally/whenComplete/handle
 *  1. whenComplete 未发生异常正常返回值发生异常就返回异常
 *  2. exceptionally 确认会发生异常
 *  3. handle 基本一致，区别在于handle有返回值
 * @author sunxind
 * @date 2022-11-10
 */
public class CallableAndCompletableFuture {
    public static void main(String[] args) {
        //任务1 创建不带返回值的异步任务
        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(() -> {
                    System.out.println("T1:洗水壶...");
                    sleep(1, TimeUnit.SECONDS);

                    System.out.println("T1:烧开水...");
                    sleep(15, TimeUnit.SECONDS);
                });

        //任务2：洗茶壶->洗茶杯->拿茶叶  创建带返回值的异步任务
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("T2:洗茶壶...");
                    sleep(1, TimeUnit.SECONDS);

                    System.out.println("T2:洗茶杯...");
                    sleep(2, TimeUnit.SECONDS);

                    System.out.println("T2:拿茶叶...");
                    sleep(1, TimeUnit.SECONDS);
                    return "龙井";
                });

        //任务3：任务1和任务2完成后执行：泡茶
        CompletableFuture<String> f3 =
                f1.thenCombine(f2, (__, tf) -> {
                    System.out.println("T1:拿到茶叶:" + tf);
                    System.out.println("T1:泡茶...");
                    return "上茶:" + tf;
                });

        //等待任务3执行结果
        System.out.println(f3.join());

    }
}