package com.jaysunxl.scaffold.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author sunxind
 * @date 2022-11-22
 */
public class TimeUtils {
    public static void main(String[] args) {
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
