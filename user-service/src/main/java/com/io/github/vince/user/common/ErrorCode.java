package com.io.github.vince.user.common;
import lombok.Getter;

@Getter
public enum ErrorCode {

    SUCCESS(0, "ok"),
    PARAM_ERROR(40001, "参数错误"),
    USER_EXIST(40002, "用户名已存在"),
    USER_NOT_FOUND(40003, "用户不存在"),
    PASSWORD_ERROR(40004, "密码错误"),
    SYSTEM_ERROR(50000, "系统内部错误");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
