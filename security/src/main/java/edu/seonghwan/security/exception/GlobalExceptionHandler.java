//package edu.seonghwan.security.exception;
//
//import edu.seonghwan.security.util.ApiUtil;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ApiUtil.ApiResult<?>> handleIllegalArgument(IllegalArgumentException e) {
//        return ResponseEntity
//                .badRequest()
//                .body(ApiUtil.error(e.getMessage(), HttpStatus.BAD_REQUEST));
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiUtil.ApiResult<?>> handleException(Exception e) {
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(ApiUtil.error("서버 오류가 발생했습니다", HttpStatus.INTERNAL_SERVER_ERROR));
//    }
//}
