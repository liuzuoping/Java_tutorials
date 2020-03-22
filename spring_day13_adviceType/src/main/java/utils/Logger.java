package utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
    public void beforeprintLog(){
        System.out.println("前置通知：Logger类中beforeprintLog方法开始记录日志了。。。");
    }
    public void afterRuturningprintLog(){
        System.out.println("后置通知：Logger类中afterRuturningprintLog方法开始记录日志了。。。");
    }
    public void afterThrowingprintLog(){
        System.out.println("异常通知：Logger类中afterThrowingprintLog方法开始记录日志了。。。");
    }
    public void afterprintLog(){
        System.out.println("最终通知：Logger类中afterprintLog方法开始记录日志了。。。");
    }
    public void aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args=pjp.getArgs();
            System.out.println("Logger类中aroundPrintLog方法开始记录日志了。。。前置");
            rtValue=pjp.proceed(args);
            System.out.println("Logger类中aroundPrintLog方法开始记录日志了。。。后置");
        }catch (Throwable t){
            System.out.println("Logger类中aroundPrintLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger类中aroundPrintLog方法开始记录日志了。。。最终");
        }
        return;rtValue;
        System.out.println("Logger类中aroundPrintLog方法开始记录日志了。。。");
    }
}
