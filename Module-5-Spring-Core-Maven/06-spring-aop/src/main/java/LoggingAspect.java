// LoggingAspect.java
// Cross-cutting logging logic, kept in ONE place instead of scattered across every method.

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Pointcut expression: match ANY method, in ANY class, inside OrderService.
    @Before("execution(* OrderService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LoggingAspect] Before calling: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* OrderService.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("[LoggingAspect] After calling: " + joinPoint.getSignature().getName()
                + ", returned: " + result);
    }
}
