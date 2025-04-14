package com.shuttlebus.response;

import com.shuttlebus.enums.error.CodeIfs;
import lombok.AccessLevel;
import lombok.Builder;

/**
 * please explain class!
 *
 * @author :Uheejoon
 * @date :2025-04-13 오후 9:08
 */
public record CommonResponse<T>(
  boolean success,
  String code,
  String message,
  T data
) {
    public static <T> CommonResponse<T> success(CodeIfs responseCode) {
        return new CommonResponse<>(true, responseCode.getCode(), responseCode.getMessage(), null);
    }

    public static <T> CommonResponse<T> success(CodeIfs responseCode, T data) {
        return new CommonResponse<>(true, responseCode.getCode(), responseCode.getMessage(), data);
    }

    public static <T> CommonResponse<T> fail(CodeIfs responseCode) {
        return new CommonResponse<>(false, responseCode.getCode(), responseCode.getMessage(), null);
    }

    public static <T> CommonResponse<T> fail(CodeIfs responseCode, T data) {
        return new CommonResponse<>(false, responseCode.getCode(), responseCode.getMessage(), data);
    }

    public static CommonResponse<String> error(CodeIfs responseCode, String message) {
        return new CommonResponse<>(false, responseCode.getCode(), message, null);
    }

    public static CommonResponse<String> error(CodeIfs responseCode, Exception exception) {
        return new CommonResponse<>(false, responseCode.getCode(), responseCode.getMessage(), exception.getMessage());
    }
}
