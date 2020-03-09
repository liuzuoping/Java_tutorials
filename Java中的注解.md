## 注解： 

 概念：说明程序的。给计算机看的
 注释：用文字描述程序的。给程序员看的

定义：注解（Annotation），也叫元数据。一种代码级别的说明。它是JDK1.5及以后版本引入的一个特性，与类、接口、枚举是在同一个层次。它可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用来对这些元素进行说明，注释。

```
作用分类：①编写文档：通过代码里标识的注解生成文档【生成文档doc文档】②代码分析：通过代码里标识的注解对代码进行分析【使用反射】③编译检查：通过代码里标识的注解让编译器能够实现基本的编译检查【Override】
```



JDK中预定义的一些注解
 @Override：检测被该注解标注的方法是否是继承自父类(接口)的
 @Deprecated：该注解标注的内容，表示已过时
 @SuppressWarnings：压制警告
 一般传递参数all @SuppressWarnings("all")

 自定义注解
 格式：
元注解
public @interface 注解名称{
属性列表;
}

 本质：注解本质上就是一个接口，该接口默认继承Annotation接口
public interface MyAnno extends java.lang.annotation.Annotation {}



```
 属性：接口中的抽象方法 要求：1. 属性的返回值类型有下列取值 基本数据类型 String 枚举 注解 以上类型的数组2. 定义了属性，在使用时需要给属性赋值1. 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。2. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可。3. 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略 元注解：用于描述注解的注解 @Target：描述注解能够作用的位置 ElementType取值： TYPE：可以作用于类上 METHOD：可以作用于方法上 FIELD：可以作用于成员变量上@Retention：描述注解被保留的阶段@Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到@Documented：描述注解是否被抽取到api文档中@Inherited：描述注解是否被子类继承
```

预先定义Demo1.java与Demo2.java,解析注解,获取注解中定义的属性值

Demo1.java

```java
public class Demo1 {
    public void show(){
        System.out.println("demo1...show...");
    }
}
```

Demo2.java

```java
public class Demo2 {
    public void show(){
        System.out.println("demo2...show...");
    }
}
```

再自定义一个注解Pro.java

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {
    String className();
    String methodName();
}
```

**接下来通过注解加载类与方法**

```java
@Pro(className = "annotation.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String [] args) throws Exception {
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        Pro an = reflectTestClass.getAnnotation(Pro.class);
        String className=an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);

        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
```

输出结果为：

```
annotation.Demo1
show
demo1...show...
```

这个时候只需要改变注解中的类名与方法名便可以实现相应的方法





案例：简单的测试框架





首先自定义一个Check注解

Check.java

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Check {
}
```

再定义要测试的对象

Calculator.java

```java
public class Calculator {
    @Check
    public void add(){
        String str = null;
        str.toString();
        System.out.println("1+0="+(1+0));
    }
    @Check
    public void sub(){
        System.out.println("1-0="+(1-0));
    }
    @Check
    public void mul(){
        System.out.println("1*0="+(1*0));
    }
    @Check
    public void div(){
        System.out.println("1/0="+(1/0));
    }
    public void show(){
        System.out.println("永无bug。。。。");
    }
}
```

接着我们开始写测试框架

TestCheck.java

```java
public class TestCheck {
    public static void main(String [] args) throws Exception {
        Calculator c  = new Calculator();
        Class cls = c.getClass();
        Method[] methods = cls.getMethods();
        int number=0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods) {
            if(method.isAnnotationPresent(Check.class)){
                try{
                    method.invoke(c);
                }catch (Exception e){
                    number++;
                    bw.write(method.getName()+"方法出现异常");
                    bw.newLine();
                    bw.write("异常的名称"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现了"+number+"次异常");
        bw.flush();
        bw.close();
    }
}
```

运行后打开产生的bug.txt文件

![img](https://mmbiz.qpic.cn/mmbiz_png/rC8JsOfxhaFGa99SN3QwXsmLEFbyHibMuVnCBlmeHkUSZCNXWialSghRLnhumKIspAOaD7ibbs7O24hgZBaQkbv4Q/640?wx_fmt=png)



关注公众号

获取更多精彩

程序员老刘

![img](https://mmbiz.qpic.cn/mmbiz_jpg/rC8JsOfxhaHYXVtVrjwEt2nsqBTK0AxIQgkOe8IJibhRaNkoyUmzCxnDia1QiaDiaw4pFLULrz81JEEibibw93wicYAow/640?wx_fmt=jpeg)






 