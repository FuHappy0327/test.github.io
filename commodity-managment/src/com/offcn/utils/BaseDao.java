package com.offcn.utils;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao<T>{
	private QueryRunner qr=new QueryRunner();
    private Class<T> type;
    public BaseDao(){
        //1. 获取子类对象
        Class aClass = this.getClass();
        //获取父类的类型;ParameterizedType该对象可以获取泛型类型
        ParameterizedType genericSuperclass = (ParameterizedType) aClass.getGenericSuperclass();
        //获取父类的泛型类型
        Type[] types = genericSuperclass.getActualTypeArguments();
        this.type= (Class) types[0];
    }
    //封装增改的方法
    public int update(String sql,Object ... objects){
        Connection connection = JdbcUtil.getConnection();
        int update=0;
        try {
            update = qr.update(connection, sql, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeConnection(connection);
        }
        return update;
    }

    //查询单条数据的方法
    public T getBean(String sql,Object ... objects){
        Connection connection = JdbcUtil.getConnection();
        BeanHandler<T> beanHandler=new BeanHandler<T>(type);
        T t=null;
        try {
            t = qr.query(connection, sql, beanHandler, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeConnection(connection);
        }
        return t;
    }

    //查询多条数据的方法
    public List<T> getBeanList(String sql, Object ... objects){
        Connection connection = JdbcUtil.getConnection();
        BeanListHandler<T> beanHandler=new BeanListHandler<T>(type);
        List<T> list=null;
        try {
            list = qr.query(connection, sql, beanHandler, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeConnection(connection);
        }
        return list;
    }

    //查询聚合函数中的数据
    public Object getSingleValue(String sql, Object ... objects){
        Connection connection = JdbcUtil.getConnection();
        ScalarHandler sc=new ScalarHandler();
        Object object=null;
        try {
            object = qr.query(connection, sql, sc, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeConnection(connection);
        }
        return object;
    }
}
