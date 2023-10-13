package edu.seonghwan.security.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @AfterThrowing(value = "execution(* edu.seonghwan.security.controller.*.*(..))", throwing = "e")
    public void AfterThrowing(JoinPoint joinPoint, Throwable e){
        log.error("AOP : Error ");
        Object arg = joinPoint.getArgs()[0];
        log.error("Method Parameter : {}", arg.toString());
        e.printStackTrace();
    }

    @AfterReturning(value = "execution(* edu.seonghwan.security.controller.*.*(..))", returning = "returnValue")
    public void AfterReturning(JoinPoint joinPoint, Object returnValue) throws RuntimeException {
        log.info("AOP : AfterReturning ");
        log.info("{} 메소드 호출", joinPoint.getSignature().toShortString());
        log.info("Return Parameter : {}", returnValue.toString());
    }

}
