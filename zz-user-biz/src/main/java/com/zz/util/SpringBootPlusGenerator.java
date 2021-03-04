
package com.zz.util;

/**
 * spring-boot-plus代码生成器入口类
 **/
public class SpringBootPlusGenerator {

    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();
        // 公共配置
        // 数据库配置
        codeGenerator
                .setUserName("root")
                .setPassword("puckteam")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setDriverUrl("jdbc:mysql://hw001.zzfactory.com:3307/zz_keystone");

        // 包信息
        codeGenerator
                .setProjectPackagePath("com/zz")
                .setParentPackage("com.zz")
                .setCorePackage("com.zz.core");

        // 项目信息
        codeGenerator
                .setApiModuleName("zz-user-api")
                .setBizModuleName("zz-user-biz")
                .setTablePrefix("");

//
//        // 项目信息
//        codeGenerator
//                .setApiModuleName("zz-user-api")
//                .setBizModuleName("zz-user-biz");

        // 组件作者等配置
        codeGenerator
                .setModuleName("user")
                .setAuthor("puck")
                .setPkIdColumnName("id");

        // 生成策略
        codeGenerator
                .setGeneratorStrategy(CodeGenerator.GeneratorStrategy.ALL)
                .setPageListOrder(true)
                .setParamValidation(true);

        // 生成实体映射相关代码,可用于数据库字段更新
        // 当数据库字段更新时，可自定义自动生成哪些那文件
        codeGenerator
                .setGeneratorEntity(true)
                .setGeneratorQueryParam(true)
                .setGeneratorQueryVo(true);

        // 生成业务相关代码
        codeGenerator
                .setGeneratorController(true)
                .setGeneratorService(true)
                .setGeneratorServiceImpl(true)
                .setGeneratorMapper(true)
                .setGeneratorMapperXml(true);

        // 是否生成Shiro RequiresPermissions注解
        codeGenerator.setRequiresPermissions(false);

        // 是否覆盖已有文件
        codeGenerator.setFileOverride(true);

        // 初始化公共变量
        codeGenerator.init();

        // 需要生成的表数组
        // xxx,yyy,zzz为需要生成代码的表名称
        String[] tables = {
                "EMPLOYEE"
        };

        // 循环生成
        for (String table : tables) {
            // 设置需要生成的表名称
            codeGenerator.setTableName(table);
            // 生成代码
            codeGenerator.generator();
        }

    }

}
