package com.itxiaoliu.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txManager")
@Aspect
public class TransactionManager {
    @Autowired
    private Connectionutils connectionutils;

    @Pointcut("execution(* com.itxiaoliu.service.impl.*.*(..))")
    private void pt1(){

    }

    public void beginTransaction(){
        try {
            connectionutils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectionutils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionutils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void release(){
        try {
            connectionutils.getThreadConnection().close();
            connectionutils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args=pjp.getArgs();
            this.beginTransaction();
            rtValue=pjp.proceed(args);
            this.commit();
            return rtValue;
        }catch (Throwable e){
            this.rollback();
            throw  new RuntimeException(e);
        }finally {
            this.release();
        }
    }
}
