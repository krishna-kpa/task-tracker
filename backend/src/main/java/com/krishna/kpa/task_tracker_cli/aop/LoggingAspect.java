package com.krishna.kpa.task_tracker_cli.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Aspect for logging execution of controller and service methods.
 * Logs method entry, parameters, exit, and exceptions.
 *
 * @author Krishna Prasad A
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("within(com.krishna.kpa.task_tracker_cli.controller..*) || within(com.krishna.kpa.task_tracker_cli.service..*)")
    public void applicationPointcut() {
        // Pointcut for controller and service layers
    }

    @Around("applicationPointcut()")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] methodArgs = joinPoint.getArgs(); // Get method parameters

        log.info("Entering method: {} with arguments: {}", methodName, Arrays.toString(methodArgs));

        Object result;
        try {
            result = joinPoint.proceed();
            log.info("Exiting method: {} with result: {}", methodName, result);
            return result;
        } catch (Exception e) {
            log.error("Exception in method: {} - {}", methodName, e.getMessage(), e);
            throw e;
        }
    }

    @AfterThrowing(pointcut = "applicationPointcut()", throwing = "ex")
    public void logException( JoinPoint joinPoint, Exception ex) {
        log.error("Exception in method: {} - {}", joinPoint.getSignature().toShortString(), ex.getMessage(), ex);
    }
}
