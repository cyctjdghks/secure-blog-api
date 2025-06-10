package edu.seonghwan.security.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiUtil {

    private static final String OK = "Success";

    public static <T> ApiResult<T> success() {
        return new ApiResult<>(HttpStatus.OK.value(), OK, null);
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(HttpStatus.OK.value(), OK, data);
    }

    public static <T> ApiResult<T> success(String message, T data) {
        return new ApiResult<>(HttpStatus.OK.value(), message, data);
    }

    public static <T> ApiResult<T> success(String message) {
        return new ApiResult<>(HttpStatus.OK.value(), message, null);
    }

    public static ApiResult<?> error(Throwable throwable, HttpStatus status) {
        return new ApiResult<>(status.value(), throwable.getMessage(), null);
    }

    public static ApiResult<?> error(String message, HttpStatus status) {
        return new ApiResult<>(status.value(), message, null);
    }

    public static ApiResult<?> error(String message, int statusCode) {
        return new ApiResult<>(statusCode, message, null);
    }

    //제네릭 사용하여 모든 API 응답을 공통화하고, data 영역만 동적으로 처리
    @AllArgsConstructor
    @Getter
    public static class ApiResult<T> {
        private final int status;
        private final String message;
        private final T data;
    }
}
