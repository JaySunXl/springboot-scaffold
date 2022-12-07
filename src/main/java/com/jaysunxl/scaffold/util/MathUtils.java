package com.jaysunxl.scaffold.util;

/**
 * @author JaySunXl
 * @date 2022-11-22
 */
public class MathUtils {
    public static void main(String[] args) {
        int list = 1010;
        System.out.println(list%100);
        int n = list % 100 == 0 ? list/100:list/100 + 1;
        System.out.println(n);
    }
}
