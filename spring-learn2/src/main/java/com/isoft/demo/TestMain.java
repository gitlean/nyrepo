package com.isoft.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
*@author anonymous
*@createTime 2020年10月25日 上午10:01:24
*@describe
*/
public class TestMain {

	public static void main(String[] args) {
        //要代理的真实对象
        People people = new Teacher();
        //或
        //People people=new Student();
        
        //代理对象的调用处理程序，我们将要代理的真实对象传入代理对象的调用处理的构造函数中，最终代理对象的调用处理程序会调用真实对象的方法
        InvocationHandler handler = new MHandler(people);//并且每个代理类的实例都关联到了实现该接口的动态代理类调用处理程序中
       
        
        /**
         * 通过Proxy类的newProxyInstance方法创建代理对象，我们来看下方法中的参数
         * 第一个参数：people.getClass().getClassLoader()，使用handler对象的classloader对象来加载我们的代理对象
         * 第二个参数：people.getClass().getInterfaces()，这里为代理类提供的接口是真实对象实现的接口，这样代理对象就能像真实对象一样调用接口中的所有方法
         * 第三个参数：handler，我们将代理对象关联到上面的InvocationHandler对象上
         */
        
        
        //proxy代理实例、代理类对象、动态代理对象
        People proxy = (People)Proxy.newProxyInstance(handler.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);
        //或
        //People proxy = (People)Proxy.newProxyInstance(people.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);

        
       
        //当我们通过动态代理对象调用一个方法时候，这个方法的调用就会被转发到实现InvocationHandler接口类的invoke方法来调用
        //System.out.println(proxy.toString());
        System.out.println(proxy.work());
        System.out.println(proxy.say());

	}

}
