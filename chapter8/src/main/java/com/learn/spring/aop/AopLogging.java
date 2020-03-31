package com.learn.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class AopLogging {

    @Pointcut("within(com.learn.spring.controller.*)")
    public void getControllerLogging(){}

    @Pointcut("within(com.learn.spring.service..*)")
    public void getServiceLogging(){}

    @Pointcut("within(com.learn.spring.dao..*)")
    public void getDaoLogging(){}

    @Around("getControllerLogging() || getServiceLogging() || getDaoLogging()")
    public Object logBeansExecutions(ProceedingJoinPoint pj) throws Throwable {
        Object result = null;

        log.debug("Before method: {} with args: {}", pj.getSignature(), Arrays.toString(pj.getArgs()));
        try {
            result = pj.proceed();
            return result;
        } catch (Exception e) {
            log.error("Caught exception during execution of method: {} with args: {}",
                    pj.getSignature(), Arrays.toString(pj.getArgs()));
            throw new RuntimeException(e);
        } finally {
            log.debug("After method: {} with result: {}", pj.getSignature(), result);
        }
    }
}
