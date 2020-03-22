package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect
public class Logger {
    @Pointcut("execution(* *..*.*(..))")
    private  void pt1(){

    }
    //@Before("pt1()")
    public void beforeprintLog(){
        System.out.println("前置通知：Logger类中beforeprintLog方法开始记录日志了。。。");
    }
    //@AfterReturning("pt1()")
    public void afterRuturningprintLog(){
        System.out.println("后置通知：Logger类中afterRuturningprintLog方法开始记录日志了。。。");
    }
    //@AfterThrowing("pt1()")
    public void afterThrowingprintLog(){
        System.out.println("异常通知：Logger类中afterThrowingprintLog方法开始记录日志了。。。");
    }
    //@After("pt1()")
    public void afterprintLog(){
        System.out.println("最终通知：Logger类中afterprintLog方法开始记录日志了。。。");
    }
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args=pjp.getArgs();
            System.out.println("Logger类中aroundPrintLog方法开始记录日志了。。。前置");
            rtValue=pjp.proceed(args);
            return rtValue;
            //System.out.println("Logger类中aroundPrintLog方法开始记录日志了。。。后置");
        }catch (Throwable t){
            System.out.println("Logger类中aroundPrintLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger类中aroundPrintLog方法开始记录日志了。。。最终");
        }
        //System.out.println("Logger类中aroundPrintLog方法开始记录日志了。。。");
    }
}
