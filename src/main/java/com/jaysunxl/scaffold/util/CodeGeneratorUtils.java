package com.jaysunxl.scaffold.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @Description
 * @Author JaySunXl
 * @Version 1.0.0
 * @Date 2022/12/7
 */
public class CodeGeneratorUtils {
    private static final String URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String DATABASE_TYPE = "oracle";

    /**
     * 快速生成代码
     */
    public void fastCreate(String... tableNames) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author("JaySunXl") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .commentDate("yyyy-MM-dd")
                            .outputDir(System.getProperty("user.dir") + "\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.jaysunxl") // 设置父包名
                            .moduleName("scaffold") // 设置父包模块名
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("dao")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "\\src\\main\\resources\\mapper\\" + DATABASE_TYPE.toLowerCase(Locale.ROOT))); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableNames) // 设置需要生成的表名
                            .addTablePrefix("SIF") // 设置过滤表前缀
                            .serviceBuilder()
                            .formatServiceFileName("I%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
                            .enableLombok()//开启lombok
                            //.logicDeleteColumnName("isDeleted")//逻辑删除字段
                            .enableTableFieldAnnotation()//属性加上说明注解
                            .controllerBuilder()
                            .formatFileName("%sController")
                            .enableHyphenStyle()//映射路径使用连字符格式而不是驼峰
                            .enableRestStyle()//添加RestController
                            .mapperBuilder()
                            .enableBaseResultMap()//生成通用的ResultMap
                            .enableBaseColumnList()//生成通用的ColumnList
                            .superClass(BaseMapper.class)//继承的父类
                            //.formatMapperFileName("%sDao")
                            .enableMapperAnnotation()//@Mapper开启
                            .formatXmlFileName("%sMapper");
                })
                .templateConfig(builder -> {
                    // 实体类使用我们自定义模板
                    builder.entity("ftl/entity.java");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    /**
     * 交互式生成代码
     */
    public void create() {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")))
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

    public static void main(String[] args) {
        new CodeGeneratorUtils().fastCreate("SIF_PROJECT");
        //System.out.println(DATABASE_TYPE.toLowerCase(Locale.ROOT));
    }

}
