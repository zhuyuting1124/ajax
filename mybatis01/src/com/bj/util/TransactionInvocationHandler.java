//动态代理
package com.bj.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {
    //成员变量
    private Object target;
    //静态方法
    public TransactionInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    //B的方法,代理类方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;
        try{
            session = SqlSessionUtil.getSession();
            //处理业务逻辑
            //A的方法，业务层实现类的方法
            obj = method.invoke(target,args);
            //处理事务
            session.commit();
        }catch(Exception e){
            session.rollback();
        }finally{
            SqlSessionUtil.myClose(session);
        }
        return obj;
    }
    public Object getProxy(){
        //取得代理类对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
