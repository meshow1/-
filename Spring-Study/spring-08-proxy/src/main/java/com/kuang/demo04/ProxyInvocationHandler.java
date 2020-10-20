package com.kuang.demo04;

import com.kuang.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {

    //被代理接口,传入的应是实现类的实例对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //生成代理类（使用时转型）
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),
                this);
    }


    //处理代理实例，返回结果，就是处理流程
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //log日志
        //通过反射调用实例对象的方法
        Object result = method.invoke(target, args);
        //log日志

        return result;
    }
}
