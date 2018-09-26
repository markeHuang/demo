package com.marke.plugin.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.config.rules.PropertyInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于mybatis-plus的代码生成类
 *
 * @author jiangming.huang
 * @date 2018/9/26 0026 下午 5:15
 */
public class MpGenerator {

    // 根据命名规范，只修改此常量值即可
    /**
     * 生成包名
     */
    private static String PACKAGE_NAME = "com.marke";

    /**
     * 数据库类型
     */
    private static DbType DB_TYPE = DbType.MYSQL;

    /**
     * 数据库驱动
     */
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 数据库连接地址
     */
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/demo?characterEncoding=utf8";

    /**
     * 数据库用户名
     */
    private static String JDBC_USERNAME = "root";

    /**
     * 数据库密码
     */
    private static String JDBC_PASSWORD = "123456";

    static {
        if (DbType.ORACLE.equals(DB_TYPE)) {
            JDBC_DRIVER = "";
        } else if (DbType.SQL_SERVER.equals(DB_TYPE)) {
            JDBC_DRIVER = "";
        }
    }

    /**
     * 自动代码生成
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 生成工具类
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 生成文件的输出目录【默认 D 盘根目录】
        gc.setOutputDir("E://ge");
        // 是否覆盖已有文件
        gc.setFileOverride(true);
        // 是否打开输出目录
        gc.setOpen(false);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(false);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(false);
        // XML columList
        gc.setBaseColumnList(false);
        // gc.setKotlin(true) 是否生成 kotlin 代码
        gc.setAuthor("vteam-generator");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DB_TYPE);
        // 自定义数据库表字段类型转换【可选】
        dsc.setTypeConvert(new MySqlTypeConvert() {

            // 自定义数据库表字段类型转换【可选】
            @Override
            public PropertyInfo processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                String typeDecimal10 = "decimal(10,0)";
                if (typeDecimal10.equals(fieldType)) {
                    return DbColumnType.INTEGER;
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }
        });
        dsc.setDriverName(JDBC_DRIVER);
        dsc.setUrl(JDBC_URL);
        dsc.setUsername(JDBC_USERNAME);
        dsc.setPassword(JDBC_PASSWORD);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 全局大写命名 ORACLE 注意
        // strategy.setCapitalMode(true);
        // 此处可以修改为您的表前缀
        // strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表（与exclude二选一配置）
        // strategy.setInclude(new String[] { "user" });
        // 排除生成的表
        // strategy.setExclude(new String[] { "FSPA_SEQ_M" });
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        // 【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        // 逻辑删除属性名称
        strategy.setLogicDeleteFieldName("DEL_FLAG");
        // 表填充字段，创建日期、更新日期
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("CREATE_DATE", FieldFill.INSERT));
        tableFillList.add(new TableFill("LAST_MOD_DATE", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("CREATE_USER", FieldFill.INSERT));
        tableFillList.add(new TableFill("LAST_MOD_USER", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("EDTID", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("DATA_STATUS", FieldFill.INSERT));

        strategy.setTableFillList(tableFillList);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_NAME);
        // Entity包名
        pc.setEntity("entity.model");
        // Mapper包名
        pc.setMapper("entity.mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        // pc.setModuleName("test");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {

            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        // mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        // tc.setXml(null);
        tc.setController(null);
        mpg.setTemplate(tc);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();

        // 打印注入设置【可无】
        // System.err.println(mpg.getCfg().getMap().get("abc"));

    }
}
