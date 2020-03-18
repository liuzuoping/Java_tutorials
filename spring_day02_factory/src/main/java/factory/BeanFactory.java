package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties props;
    private static Map<String,Object> beans;
    static {
        try {
            props=new Properties();
            InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beans=new HashMap<String, Object>();
            Enumeration<Object> keys = props.keys();
            while (keys.hasMoreElements()){
                String key=keys.nextElement().toString();
                String beanPath=props.getProperty(key);
                Object value=Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
//        Object bean=null;
//        try {
//            String beanPath=props.getProperty(beanName);
//            bean=Class.forName(beanPath).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
