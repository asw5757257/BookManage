package com.zyw.appoint.exception;

/**
 * @program: BookAppointment
 * @description: 异常类
 * @author: Cengyuwen
 * @create: 2019-06-03 20:16
 **/

public class AppointException extends RuntimeException{
    public AppointException(String message) {
        super(message);
    }
    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
