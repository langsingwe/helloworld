package ch04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Audience
 * @date 2021.04.11
 */
@Aspect
@Component
public class Audience {

    @Pointcut("execution(**ch04.Performace.perform(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void test1() {
        System.out.println("before...");
    }

    @AfterReturning("pointCut()")
    public void test2() {
        System.out.println("after...");
    }

    @AfterThrowing("pointCut()")
    public void test3() {
        System.out.println("exception...");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {

        }

    }
}
