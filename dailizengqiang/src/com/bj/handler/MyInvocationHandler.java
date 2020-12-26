package com.bj.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target = null;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //调用目标方法
        Object res = method.invoke(target,objects);
        //需要自己改结果
        if(res != null){
            Integer num = (Integer)res;
            res = num * 2;
        }
        return res;
    }
}
