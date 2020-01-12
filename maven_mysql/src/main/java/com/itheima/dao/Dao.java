package com.itheima.dao;

import java.util.List;
import com.itheima.domain.Items;
public interface Dao {
    public List<Items> findAll() throws Exception;
}
