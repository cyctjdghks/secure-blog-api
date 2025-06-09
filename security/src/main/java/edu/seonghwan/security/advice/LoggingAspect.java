package edu.seonghwan.security.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* edu.seonghwan.security.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("{} 메소드 호출", joinPoint.getSignature().toShortString());
    }

    @AfterReturning(value = "execution(* edu.seonghwan.security.controller.*.*(..))", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        log.info("Return Parameter : {}", returnValue);
    }

    @AfterThrowing(value = "execution(* edu.seonghwan.security.controller.*.*(..))", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = getRequest();
//        String ip = request.getRemoteAddr();
        String uri = request.getRequestURI();

        log.error("{} → {} 메소드에서 예외 발생: {}", uri, joinPoint.getSignature().toShortString(), e.getMessage(), e);
    }

    @After("execution(* edu.seonghwan.security.controller.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("{} 메소드 실행 완료", joinPoint.getSignature().toShortString());
    }

    @Around("execution(* edu.seonghwan.security.controller.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();
            long duration = end - start;

            HttpServletRequest request = getRequest();
//            String ip = request.getRemoteAddr();
            String uri = request.getRequestURI();

            if (duration > 1000) {
                log.warn("{} → {} 메소드 실행 시간: {} ms", uri, joinPoint.getSignature().toShortString(), duration);
            } else {
                log.info("{} → {} 메소드 실행 시간: {} ms", uri, joinPoint.getSignature().toShortString(), duration);
            }
        }
    }

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}