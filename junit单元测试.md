
测试分类：
   \1. 黑盒测试：不需要写代码，给输入值，看程序是否能够输出期望的值。
   \2. 白盒测试：需要写代码的。关注程序具体的执行流程。

一般测试，例如我们写了一个计算器类用来满足加减乘除的操作

```java
public class Calculator {
    public int add(int a,int b){
        return a+b;
​    }
    public int sub(int a,int b){
        return a-b;
    }
    public int mul(int a,int b){
        return a*b;
    }
    public int div(int a,int b){
        return a/b;
    }
}
```



**那么一般测试我们需要在同级目录下写一个test文件来创建对象并调用**

```java
public class CalculatorTest {
    public static void main(String [] args){
        //创建对象
        Calculator c = new Calculator();
        //调用
        int result=c.add(1, 2);
        System.out.println(result);
    }
}
```

但是一个类中只能有一个主方法，所以测试完加法再去测试其他方法时就非常不方便，需要注释原有测试再去写新的测试



**Junit使用：白盒测试**
步骤：
     \1. 定义一个测试类(测试用例)

​     \2. 定义测试方法：可以独立运行
​       \* 建议：
​         \* 方法名：test测试的方法名     testAdd()  
​         \* 返回值：void
​         \* 参数列表：空参

​     \3. 给方法加@Test


     \4. 导入junit依赖环境

![img](https://mmbiz.qpic.cn/mmbiz_png/rC8JsOfxhaFGa99SN3QwXsmLEFbyHibMu087JYcFY9vP3Vic7vEUEia9xlMllsjtaHCtIrTBG4BlJ5MlvqGhVBz1A/640?wx_fmt=png)

**使用junit来测试Calculator类**

![img](https://mmbiz.qpic.cn/mmbiz_png/rC8JsOfxhaFGa99SN3QwXsmLEFbyHibMu2EtqrkTYEMS0OFZNkVX8ugcY0CRrN7NNwmLG1FWXszhDcTeXwaNYBQ/640?wx_fmt=png)

```java
public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        System.out.println(result);
        //断言
        Assert.assertEquals(3, result);
    }
    @Test
    public void testSub(){
        Calculator c = new Calculator();
        int result = c.sub(1, 2);
        System.out.println(result);
        //断言
        Assert.assertEquals(-1, result);
    }

}
```



这样可以同时测试多个方法而不用将其他方法注释后再去测试新的方法




 