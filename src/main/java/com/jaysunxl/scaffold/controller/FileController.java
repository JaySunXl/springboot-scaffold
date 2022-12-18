package com.jaysunxl.scaffold.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author JaySunXl
 * @Version 1.0.0
 * @Date 2022/12/13
 */
@Controller
@RequestMapping("file")
public class FileController {

    /**
     * 上传文件
     */
    @RequestMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        //System.out.println(file.getName());
        //业务逻辑
        //读取文件内容
        int len;
        InputStream is = file.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //BufferedReader br = new BufferedReader(in);
        byte[] buf = new byte[128];

        while ((len = is.read(buf)) != -1) {
            //将缓冲区内容写进输出流，0是从起始偏移量，len是指定的字符个数
            baos.write(buf, 0, len);
        }
        String result = baos.toString();
        System.out.println(result);
        return "文件上传成功";
    }

    /**
     * 下载文件
     *
     * @param fileName 文件名称
     */
    @RequestMapping("download")
    public void download(String fileName, HttpServletResponse response) {
        JSONObject retJson = new JSONObject();

        retJson.put("test", "123");
        retJson.put("test1", "1234");
        retJson.put("test2", "1235");

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain");
        //设置文件的名称和格式
        response.addHeader("Content-Disposition", "attachment;filename="
                + fileName //设置名称格式，没有这个中文名称无法显示
                + ".txt");
        BufferedOutputStream buff = null;
        ServletOutputStream outStr = null;
        try {
            outStr = response.getOutputStream();
            buff = new BufferedOutputStream(outStr);
            buff.write(retJson.toJSONString().getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            //LOGGER.error("导出文件文件出错:{}",e);
        } finally {
            try {
                buff.close();
                outStr.close();
            } catch (Exception e) {
                //LOGGER.error("关闭流对象出错 e:{}",e);
                e.printStackTrace();
            }
        }

    }
}
