package com.isoft.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author anonymous
 * @createTime 2020年10月25日 上午10:00:13
 * @describe
 * 
 * 每一个动态代理类的调用处理程序都必须实现InvocationHandler接口
 */
public class MHandler  implements InvocationHandler{
	// 代理类中的真实对象
	private Object obj;

	public MHandler() {
		// TODO Auto-generated constructor stub
	}

	// 构造函数，给我们的真实对象赋值
	public MHandler(Object obj) {
		this.obj = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 在真实的对象执行之前我们可以添加自己的操作
		System.out.println("before invoke。。。");
		Object invoke = method.invoke(obj, args);
		// 在真实的对象执行之后我们可以添加自己的操作
		System.out.println("after invoke。。。");
		return invoke;
	}
}
