package com.stussy.stussyclone20220929wonil.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/*
* 메소드 실행 시간을 계산해주는 로직
* */

@Slf4j
@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.stussy.stussyclone20220929wonil.controller..*.*(..))")
    private void executionPointCut(){

    }

    @Around("executionPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();
        log.info("class: {}, method: {} >>> {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                stopWatch.getTotalTimeSeconds());

        return result;
    }
}
