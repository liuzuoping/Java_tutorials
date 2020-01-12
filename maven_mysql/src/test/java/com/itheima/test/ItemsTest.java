package com.itheima.test;

import com.itheima.dao.Dao;
import com.itheima.dao.impl.DaoImpl;
import com.itheima.domain.Items;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    @Test
    public void findall() throws Exception{
        Dao dao=new DaoImpl();
        List<Items> list=dao.findAll();
        for(Items items:list){
            System.out.println(items.getNAME());
        }
    }
}
