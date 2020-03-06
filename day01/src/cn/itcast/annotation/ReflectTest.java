package cn.itcast.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类
 */
@Pro(className = "cn.itcast.annotation.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，可以执行任意方法

        /*
            前提：不能改变该类的任何代码。可以创建任意类的对象，可以执行任意方法
         */
        Class<ReflectTest> reflectTestClass=ReflectTest.class;
        Pro an=reflectTestClass.getAnnotation(Pro.class);
        String className=an.className();
        String methodName=an.methodName();
        System.out.println(className);
        System.out.println(methodName);

        Class cls=Class.forName(className);
        Object obj = cls.newInstance();
        Method method=cls.getMethod(methodName);
        method.invoke(obj);
    }
}
