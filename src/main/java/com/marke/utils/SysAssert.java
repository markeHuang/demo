package com.marke.utils;

import com.marke.exception.CustomException;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 断言类 .<br>
 *
 * @author andy.sher
 * @date 2018/8/6 17:49
 */
public final class SysAssert {

    private SysAssert() {
    }

    /**
     * EMAIL 正则表达式
     */
    public static final String EMAIL_REG = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    /**
     * 手机号 正则表达式
     */
    private static final String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    /**
     * 非空 .<br>
     *
     * @param t       对象
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/8/6 17:50
     */
    public static <T> void notNull(T t, String message) {
        if (null == t) {
            throw new CustomException(message);
        }
    }

    /**
     * 为空 .<br>
     *
     * @param t       对象
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/8/6 17:50
     */
    public static <T> void isNull(T t, String message) {
        isNull(t, message, null);
    }

    /**
     * 为空 .<br>
     *
     * @param t       对象
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/8/6 17:50
     */
    public static <T> void isNull(T t, String message, Map<String, String> model) {
        if (null != t) {
            throw new CustomException(message, model);
        }
    }

    /**
     * 不为空字符 .<br>
     *
     * @param str     字符串
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/8/6 17:50
     */
    public static void notBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new CustomException(message);
        }
    }

    /**
     * 为空字符 .<br>
     *
     * @param str     字符串
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/8/6 17:50
     */
    public static void isBlank(String str, String message) {
        if (StringUtils.isNotBlank(str)) {
            throw new CustomException(message);
        }
    }

    /**
     * 字符串相等
     *
     * @param srr1    字符串1
     * @param str2    字符串2
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/8/24 13:10
     */
    public static void eq(@NotNull String srr1, @NotNull String str2, String message) {
        eq(srr1, str2, message, null);
    }

    /**
     * 字符串相等
     *
     * @param srr1    字符串1
     * @param str2    字符串2
     * @param message 错误信息
     * @param model   填充数据
     * @return void
     * @author andy.sher
     * @date 2018/8/24 13:10
     */
    public static void eq(@NotNull String srr1, @NotNull String str2, String message, Map<String, String> model) {
        if (!srr1.equals(str2)) {
            throw new CustomException(message, model);
        }
    }

    /**
     * 字符串相等（忽略大小写） .
     *
     * @param srr1    字符串1
     * @param str2    字符串2
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/8/24 13:10
     */
    public static void equalsIgnoreCase(@NotNull String srr1, @NotNull String str2, String message) {
        if (!srr1.equalsIgnoreCase(str2)) {
            throw new CustomException(message);
        }
    }

    /**
     * 日期1在日期2之后 .
     *
     * @param date1   日期1
     * @param date2   日期2
     * @param message 错误信息
     * @return void
     * @author zack.yin
     * @date 2018/8/28 13:39
     */
    public static void after(@NotNull LocalDateTime date1, @NotNull LocalDateTime date2, String message) {
        if (!date1.isAfter(date2)) {
            throw new CustomException(message);
        }
    }

    /**
     * 日期1在日期2之前 .
     *
     * @param date1   日期1
     * @param date2   日期2
     * @param message 错误信息
     * @return void
     * @author zack.yin
     * @date 2018/8/28 13:44
     */
    public static void before(@NotNull LocalDateTime date1, @NotNull LocalDateTime date2, String message) {
        if (!date1.isBefore(date2)) {
            throw new CustomException(message);
        }
    }

    /**
     * 小数1大于小数2 .
     *
     * @param num1    小数1
     * @param num2    小数2
     * @param message 错误信息
     * @return void
     * @author zack.yin
     * @date 2018/8/28 13:51
     */
    public static void gt(@NotNull BigDecimal num1, @NotNull BigDecimal num2, String message) {
        if (num1.compareTo(num2) != 1) {
            throw new CustomException(message);
        }
    }

    /**
     * 小数1小于等于小数2 .
     *
     * @param num1    小数1
     * @param num2    小数2
     * @param message 错误信息
     * @return void
     * @author zack.yin
     * @date 2018/8/28 13:54
     */
    public static void le(@NotNull BigDecimal num1, @NotNull BigDecimal num2, String message) {
        if (num1.compareTo(num2) != -1) {
            throw new CustomException(message);
        }
    }

    /**
     * 数字1小于数字2
     *
     * @param num1
     * @param num2
     * @param message
     * @return void
     * @author fu.tong
     * @date 2018/9/18 14:37
     */
    public static void lt(@NotNull BigDecimal num1, @NotNull BigDecimal num2, String message) {
        if (num1.compareTo(num2) == 1) {
            throw new CustomException(message);
        }
    }

    /**
     * 小数1等于小数2 .
     *
     * @param num1    小数1
     * @param num2    小数2
     * @param message 错误信息
     * @return void
     * @author zack.yin
     * @date 2018/8/28 13:59
     */
    public static void eq(@NotNull BigDecimal num1, @NotNull BigDecimal num2, String message) {
        if (num1.compareTo(num2) != 0) {
            throw new CustomException(message);
        }
    }

    /**
     * 验证电子邮箱格式
     *
     * @param field
     * @param message
     * @return void
     * @author zack.yin
     * @date 2018/7/23 18:59
     */
    public static void isEmail(@Nullable String field, String message) {
        // 复杂匹配
        Pattern p = Pattern.compile(EMAIL_REG);
        Matcher m = p.matcher(field);
        if (!m.matches()) {
            throw new CustomException(message);
        }
    }

    /**
     * 验证手机号格式
     *
     * @param field
     * @param message
     * @return void
     * @author zack.yin
     * @date 2018/7/24 9:07
     */
    public static void isPhoneNum(@Nullable String field, String message) {
        if (StringUtils.isBlank(field)) {
            throw new IllegalArgumentException(message);
        }
        Pattern p = Pattern.compile(PHONE_NUMBER_REG);
        Matcher m = p.matcher(field);
        if (!m.matches()) {
            throw new CustomException(message);
        }
    }

    /**
     * 参数1必须大于参数2 .
     *
     * @param param1  参数1
     * @param param2  参数2
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/8/24 19:33
     */
    public static void gt(int param1, int param2, String message) {
        if (param1 < param2 || param1 == param2) {
            throw new CustomException(message);
        }
    }

    /**
     * 参数1必须大于等于参数2 .
     *
     * @param param1  参数1
     * @param param2  参数2
     * @param message 错误信息
     * @return void
     * @author zack.yin
     * @date 2018/9/13 16:51
     */
    public static void ge(int param1, int param2, String message) {
        if (param1 < param2) {
            throw new CustomException(message);
        }
    }

    /**
     * 参数1必须小于等于参数2 .
     *
     * @param param1
     * @param param2
     * @param message
     * @return void
     * @author zack.yin
     * @date 2018/9/4 14:59
     */
    public static void le(int param1, int param2, String message) {
        le(param1, param2, message, null);
    }

    /**
     * 参数1必须小于等于参数2 .
     *
     * @param param1
     * @param param2
     * @param message
     * @param model
     * @return void
     * @author zack.yin
     * @date 2018/9/4 14:59
     */
    public static void le(int param1, int param2, String message, Map<String, String> model) {
        if (param1 > param2) {
            throw new CustomException(message, model);
        }
    }

    /**
     * 数字相等 .
     *
     * @param param1  参数1
     * @param param2  参数2
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/8/27 19:17
     */
    public static void eq(int param1, int param2, String message) {
        if (param1 != param2) {
            throw new CustomException(message);
        }
    }

    /**
     * 数字不相等 .
     *
     * @param param1  参数1
     * @param param2  参数2
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/10/19 19:17
     */
    public static void ne(int param1, int param2, String message) {
        if (param1 == param2) {
            throw new CustomException(message);
        }
    }

    /**
     * 字符串1和字符串2不相等 .
     *
     * @param str1    字符串1
     * @param str2    字符串2
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/8/31 10:16
     */
    public static void ne(@NotNull String str1, @NotNull String str2, String message) {
        if (str1.equals(str2)) {
            throw new CustomException(message);
        }
    }

    /**
     * 集合为空
     *
     * @param
     * @return void
     * @author jiangming.huang
     * @date 2018/9/3 20:21
     */
    public static <T> void isEmpty(Collection<T> coll, String message) {
        if (CollectionUtils.isNotEmpty(coll)) {
            throw new CustomException(message);
        }
    }

    /**
     * 集合不为空
     *
     * @param
     * @return void
     * @author jiangming.huang
     * @date 2018/9/3 20:21
     */
    public static <T> void notEmpty(Collection<T> coll, String message) {
        if (CollectionUtils.isEmpty(coll)) {
            throw new CustomException(message);
        }
    }

    /**
     * 如果附件不存在,抛出异常
     *
     * @param filename
     * @param message
     * @author zhuang.shao
     * @date 2018年9月6日 下午2:37:28
     */
    public static void fileExist(@NotNull String filename, String message) {
        File file = new File(filename);
        if (!file.exists()) {
            throw new CustomException(message);
        }
    }

    /**
     * 参数值为假 .
     *
     * @param param   参数
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/10/19 11:23
     */
    public static void isFalse(boolean param, String message) {
        if (param) {
            throw new CustomException(message);
        }
    }

    /**
     * 参数值为假 .
     *
     * @param param   参数
     * @param message 错误信息
     * @return void
     * @author andy.sher
     * @date 2018/10/19 11:23
     */
    public static void isTrue(boolean param, String message) {
        isFalse(!param, message);
    }
}
