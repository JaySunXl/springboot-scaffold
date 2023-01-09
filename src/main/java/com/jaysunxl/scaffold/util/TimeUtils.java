package com.jaysunxl.scaffold.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author JaySunXl
 * @date 2022-11-22
 */
@Slf4j
public class TimeUtils {

    public static String convertToStr(LocalDateTime time) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static void main(String[] args) throws ParseException {
        //String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //System.out.println(Date.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));

        //System.out.println(new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-01-01 21:00:00").getTime()));
        //System.out.println(Timestamp.valueOf(LocalDateTime.now()));
        String data = "null";
        Timestamp dataDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data).getTime());
        System.out.println(dataDate);
    }
}
