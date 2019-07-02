package com.zyw.appoint.exception;

/**
 * @program: BookAppointment
 * @description: 数量不足异常
 * @author: Cengyuwen
 * @create: 2019-06-03 20:16
 **/

public class NoNumberException extends RuntimeException{
    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
