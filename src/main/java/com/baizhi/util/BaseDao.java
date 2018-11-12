package com.baizhi.util;

import com.baizhi.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T>{
    void insert(T t);          //增加
    void delete(String id);    //删除
    T queryOne(String id);     //根据id查询一个对象
    void update(T t);          //修改
    List<T> findAll();         //查询所有
    long total();             //统计总条数
    List<T> showPages(@Param("start") Integer start, @Param("rows") Integer rows);  //分页展示
}