package com.marke.advice;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.marke.api.entity.RespEntity;
import com.marke.api.enums.RespCodeEnum;
import com.marke.exception.CustomException;
import com.marke.plugin.cache.I18NCache;
import com.marke.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 统一异常处理器
 *
 * @author marke.huang
 * @date 2018/11/18 19:41
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Resource(type = I18NCache.class)
    private I18NCache i18NCache;

    /**
     * 获取栈异常信息
     *
     * @param throwable
     * @return java.lang.String
     * @author marke.huang
     * @date 2018/11/18 19:42
     */
    private String getStackTrace(Throwable throwable) {
        String errorInfo = StringUtils.EMPTY;
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw);) {
            // 将出错的栈信息输出到printWriter中
            throwable.printStackTrace(pw);
            pw.flush();
            sw.flush();
            errorInfo = sw.toString();
        } catch (IOException e) {
            log.error(GlobalExceptionHandler.class.getName(), e);
        }
        return errorInfo;
    }

    /**
     * 默认异常处理器 .<br>
     *
     * @param e 异常对象
     * @return com.vteam.sme.api.entity.RespEntity 响应对象
     * @author andy.sher
     * @date 2018/7/11 14:38
     */
    @ExceptionHandler(value = Exception.class)
    public RespEntity defaultErrorHandler(Exception e) {
        log.error(getStackTrace(e));
        return new RespEntity(RespCodeEnum.FAILD);
    }

    /**
     * 认证失败异常
     *
     * @param e
     * @return com.marke.api.entity.RespEntity
     * @author marke.huang
     * @date 2018/11/18 19:43
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public RespEntity unauthenticatedExceptionHandler(UnauthenticatedException e) {
        log.error(getStackTrace(e));
        return RespEntity.unauthenticated();
    }

    /**
     * 授权失败异常
     *
     * @param e
     * @return com.marke.api.entity.RespEntity
     * @author marke.huang
     * @date 2018/11/18 19:43
     */
    @ExceptionHandler(UnauthorizedException.class)
    public RespEntity unauthorizedExceptionHandler(UnauthorizedException e) {
        log.error(getStackTrace(e));
        return RespEntity.unauthorized();
    }

    /**
     * token解码异常
     *
     * @param e
     * @return com.marke.api.entity.RespEntity
     * @author marke.huang
     * @date 2018/11/18 19:43
     */
    @ExceptionHandler(JWTDecodeException.class)
    public RespEntity jwtDecodeExceptionHandler(JWTDecodeException e) {
        log.error(getStackTrace(e));
        return RespEntity.invalid();
    }

    /**
     * 自定义异常处理器
     *
     * @param e
     * @return com.marke.api.entity.RespEntity
     * @author marke.huang
     * @date 2018/11/18 19:44
     */
    @ExceptionHandler(CustomException.class)
    public RespEntity customExceptionHandler(CustomException e) {
        log.error(getStackTrace(e));
        RespEntity respEntity = new RespEntity(RespCodeEnum.FAILD, null);
        if (StringUtils.isNotBlank(e.getMessage())) {
            // 获取国际化信息
            String message = i18NCache.getI18N(e.getMessage());
            // 如果存在模型则进行模型填充
            if (null != e.getModel() && !e.getModel().isEmpty()) {
                Iterator<Map.Entry<String, String>> model = e.getModel().entrySet().iterator();
                Map.Entry<String, String> entry;
                Pattern pattern;
                Matcher matcher;
                while (model.hasNext()) {
                    entry = model.next();
                    pattern = Pattern.compile(String.format("\\$\\{%s\\}", entry.getKey()));
                    matcher = pattern.matcher(message);
                    if (matcher.find()) {
                        message = matcher.replaceAll(entry.getValue());
                    } else {
                        log.error(GlobalExceptionHandler.class.getName(), String.format("填充错误信息模型时出错！[%s]中没有找到[%s]", message, entry.getKey()));
                    }
                }
                respEntity.setMsg(message);
            } else {
                respEntity.setMsg(e.getMessage());
            }
        }
        return respEntity;
    }

    /**
     * 非法参数异常统一处理器
     *
     * @param e
     * @return com.marke.api.entity.RespEntity
     * @author marke.huang
     * @date 2018/11/18 19:44
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public RespEntity illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error(getStackTrace(e));
        return new RespEntity(RespCodeEnum.ILLEGAL_PARAMETER);
    }

}
