package com.jaysunxl.scaffold.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author sunxind
 * @date 2022-11-22
 */
public class TimeUtils {
    public static void main(String[] args) throws ParseException {
        //String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //System.out.println(Date.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));

        //System.out.println(new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-01-01 21:00:00").getTime()));
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));
    }
}