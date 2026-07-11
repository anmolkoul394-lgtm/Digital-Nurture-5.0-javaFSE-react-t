package com.dn5.week2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Module 5 -> "Spring AOP (Aspect-Oriented Programming)" subtopic.
 * Covers: aspects, advice types, pointcuts/joinpoints, and how the AOP
 * proxy transparently wraps every method in the service layer.
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut: every method in every class under the service package
    @Pointcut("execution(* com.dn5.week2.service..*(..))")
    public void serviceLayer() {}

    @Before("serviceLayer()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("-> Entering {} with args {}",
                joinPoint.getSignature().toShortString(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "serviceLayer()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("<- Exiting {} returning {}",
                joinPoint.getSignature().toShortString(), result);
    }

    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.error("!! Exception in {}: {}",
                joinPoint.getSignature().toShortString(), ex.getMessage());
    }

    // Around advice: measures execution time of every service method
    @Around("serviceLayer()")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long elapsed = System.currentTimeMillis() - start;
        log.info("[TIMING] {} executed in {} ms", pjp.getSignature().toShortString(), elapsed);
        return result;
    }
}
