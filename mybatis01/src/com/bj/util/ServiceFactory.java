package com.bj.util;

public class ServiceFactory {
    //取得代理类对象必须通过代理类
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
