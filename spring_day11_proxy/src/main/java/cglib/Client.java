package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import proxy.IProducer;
import proxy.Producer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static proxy.Producer.*;

public class Client {
    public static void main(String [] args){
        final cglib.Producer producer=new cglib.Producer();
        cglib.Producer cglibProducer=(cglib.Producer)Enhancer.create(producer.getClass(), new MethodInterceptor(){
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue=null;
                Float money=(Float)args[0];
                if("saleProduct".equals(method.getName())){
                    return method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(1200f);
    }
}
