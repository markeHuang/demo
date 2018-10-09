package com.marke.constant;

/**
 * 全局常量类
 *
 * @author marke.huang
 * @date 2018/9/27 0027 下午 3:46
 */
public final class GlobalConstants {

    private GlobalConstants() {
    }

    /**
     * 短信配置
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:47
     */
    public final class Sms {
        private Sms() {
        }

    }

    /**
     * 字符编码
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:47
     */
    public final class Character {

        /**
         * 万国码
         */
        public static final String UTF_8 = "UTF-8";

        /**
         * 汉字内码扩展规范
         */
        public static final String GBK = "GBK";

        /**
         * 汉字内码扩展规范
         */
        public static final String GB2312 = "GB2312";

        /**
         * ASCII
         */
        public static final String ASCII = "ASCII";
    }

    /**
     * 文件格式
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:47
     */
    public final class FileFormat {

        /**
         * 图片格式
         */
        public static final String JPEG = "jpeg";

        /**
         * 压缩包格式
         */
        public static final String ZIP = "zip";

        /**
         * Freemarker模板格式
         */
        public static final String FTL = "ftl";

    }

    /**
     * 邮件发送模式
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:47
     */
    public enum EmailSendMode {
        /**
         * 普通文本邮件
         */
        SIMPLE,
        /**
         * HTML多媒体邮件
         */
        HTML,
        /**
         * 模板邮件
         */
        TEMPLATE,
    }

    /**
     * 符号
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:48
     */
    public final class Symbol {
        /**
         * 逗号
         */
        public static final String COMMA = ",";

        /**
         * 减号
         */
        public static final String MINUS = "-";

        /**
         * 空格
         */
        public static final String SPACE = " ";

        /**
         * 点
         */
        public static final String SPOT = ".";
        /**
         * 正斜杠
         */
        public static final String SLASH = "/";

        /**
         * 反斜杠
         */
        public static final String BACKSLASH = "\\";

        /**
         * 下划线
         */
        public static final String UNDERLINE = "_";
        
        /**
         * 左中括号
         */
        public static final String LEFT_SQUARE_BRACKET = "[";
        
        /**
         * 右中括号
         */
        public static final String RIGHT_SQUARE_BRACKET = "]";
        
    }

    /**
     * 数据库
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:48
     */
    public final class DbType {
        /**
         * MYSQL数据库
         */
        public static final String SYSTEM_DB_MYSQL = "MYSQL";

        /**
         * ORACLE数据库
         */
        public static final String SYSTEM_DB_ORACLE = "ORACLE";

        /**
         * MSSQL数据库
         */
        public static final String SYSTEM_DB_SQLSERVER = "MSSQL";
    }

    /**
     * 标记
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:48
     */
    public final class Flag {
        /**
         * 标记A
         */
        public static final String FLAG_A = "A";
        /**
         * 标记B
         */
        public static final String FLAG_B = "B";
        /**
         * 标记C
         */
        public static final String FLAG_C = "C";
        /**
         * 标记D
         */
        public static final String FLAG_D = "D";
        /**
         * 标记E
         */
        public static final String FLAG_E = "E";
        /**
         * 真
         */
        public static final String TRUE = "1";
        /**
         * 假
         */
        public static final String FALSE = "0";
        /**
         * Y
         */
        public static final String YES = "Y";
        /**
         * N
         */
        public static final String NO = "N";
        /**
         * token
         */
        public static final String TOKEN = "Authorization";
        /**
         * UUID
         */
        public static final String UUID = "uuid";
        /**
         * 验证码
         */
        public static final String VERIFICATION_CODE = "verificationCode";
        /**
         * 用户登录
         */
        public static final String LOGIN = "login";
        /**
         * 用户登出
         */
        public static final String LOGOUT = "logout";
        /**
         * 内容
         */
        public static final String CONTENT = "content";
        /**
         * 地址
         */
        public static final String ADDRESS = "address";
        /**
         * 生产环境
         */
        public static final String PROD = "prod";
        /**
         * 成功
         */
        public static final String SUCCESS = "success";
        /**
         * 过期
         */
        public static final String EXPIRED = "expired";
        /**
         * 无效
         */
        public static final String INVALID = "invalid";
        /**
         * 文件
         */
        public static final String FILE = "file";
        /**
         * 类名
         */
        public static final String CLASS_NAME = "className";
        /**
         * Java文件后缀
         */
        public static final String JAVA_FILE_SUFFIX = ".java";
        /**
         * user.dir
         */
        public static final String USER_DIR = "user.dir";
        /**
         * admin
         */
        public static final String ADMIN = "admin";
    }

    /**
     * 日期格式常量类
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 3:48
     */
    public final class DateFormat {
        public static final String YYYY_MM = "yyyy-MM";

        public static final String YYYY_MM_DD = "yyyy-MM-dd";

        public static final String MM_DD = "MM-dd";

        public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

        public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

        public static final String YYYY_MM_DD_HH_MM_SS_SSSS = "yyyy-MM-dd HH:mm:ss SSSS";

        public static final String YYYY_MMDD = "yyyyMMdd";

        public static final String YYYY_MMDD_HH = "yyyyMMddHH";

        public static final String YYYY_MMDD_HHMM = "yyyyMMddHHmm";

        public static final String YYYY_MMDD_HHMMSS = "yyyyMMddHHmmss";

        public static final String YYYY_MMDD_HHMMSS_SSSS = "yyyyMMddHHmmssSSSS";

        public static final String Y = "y";

        public static final String M = "m";

        public static final String D = "d";

        public static final String YYYY_M_D = "yyyy/M/d";
    }

    /**
     * 安全散列算法常量类
     *
     * @author marke.huang
     * @date 2018/9/27 0027 下午 5:20
     */
    public final class SecureHashAlgorithm {
        public static final String SHA_1 = "SHA-1";

        public static final String SHA_256 = "SHA-256";
    }

    /**
     * http请求类型
     *
     * @author jiangming.huang
     * @date 2018/10/9 0009 下午 4:00
     */
    public final class RequestMethod {
        public static final String GET = "GET";

        public static final String POST = "POST";
    }
}
