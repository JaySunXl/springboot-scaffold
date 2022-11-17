package com.jaysunxl.scaffold.thread;

/**
 * @author sunxind
 * @date 2022-11-10
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("主线程启动");
        //Thread.currentThread().get
        System.out.println(new AsyncCallable().call());
        new AsyncThread().start();
        new AsyncRunnable().run();
        System.out.println("主线程执行完成");
    }
}
