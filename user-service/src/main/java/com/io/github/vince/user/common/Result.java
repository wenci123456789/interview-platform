package com.io.github.vince.user.common;

import lombok.Data;

@Data
public class Result<T> {

    private int code;       // 0 表示成功，非 0 表示失败
    private String message; // 提示信息
    private T data;         // 返回的数据

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功（有数据）
    public static <T> Result<T> success(T data) {
        return new Result<>(0, "ok", data);
    }

    // 成功（无数据）
    public static <T> Result<T> success() {
        return new Result<>(0, "ok", null);
    }

    // 失败（自定义 code + message）
    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message, null);
    }
}
