package com.zyw.appoint.exception;

/**
 * @program: BookAppointment
 * @description: 重复异常
 * @author: Cengyuwen
 * @create: 2019-06-03 20:17
 **/

public class RepeatAppointException extends RuntimeException {
    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
