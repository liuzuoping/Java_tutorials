package cn.itcast.test;

import cn.itcast.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     * 初始化方法
     * 用于资源申请，所有测试方法执行前都会执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * 释放资源方法
     * 在所有测试方法执行完成后，会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close");
    }
    /**
     * 测试add方法
     */
    @Test
    public void testAdd(){
        //System.out.println("我被执行了");
        //创建计算器对象
        Calculator c = new Calculator();
        //调用add方法
        System.out.println("testAdd...");
        int result=c.add(1, 2);
        //System.out.println(result);
        //断言操作
        Assert.assertEquals(3, result);
    }
    @Test
    public void testSub(){
        Calculator c=new Calculator();
        int result=c.sub(1, 2);
        System.out.println("testSub...");
        Assert.assertEquals(-1, result);
    }
}
