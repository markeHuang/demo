package com.marke.exception;

import lombok.Getter;

import java.util.Map;

/**
 * 自定义异常
 *
 * @author marke.huang
 * @date 2018/11/18 15:46
 */
@Getter
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 2391518655024904724L;

    private Map<String, String> model;

    public CustomException(String msg) {
        super(msg);
    }

    public CustomException(String msg, Map<String, String> model) {
        super(msg);
        this.model = model;
    }

    public CustomException() {
        super();
    }

}
