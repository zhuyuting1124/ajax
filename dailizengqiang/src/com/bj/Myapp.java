package com.bj;

import com.bj.handler.MyInvocationHandler;
import com.bj.service.HelloService;
import com.bj.service.gongneng;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Myapp {
    public static void main(String[] args) {
        //gongneng gn = new gongneng();
        //int num = gn.print("销售");
        //System.out.println("num=" + num);
        gongneng gn = new gongneng();
        InvocationHandler handler = new MyInvocationHandler(gn);
        HelloService proxy = (HelloService) Proxy.newProxyInstance(gn.getClass().getClassLoader(),gn.getClass().getInterfaces(),handler);
        int num = proxy.print("市场");
        System.out.println(num);

    }
}
