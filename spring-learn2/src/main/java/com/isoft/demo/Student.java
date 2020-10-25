package com.isoft.demo;
/**
*@author anonymous
*@createTime 2020年10月25日 上午9:59:43
*@describe
*/
public class Student implements People {

	@Override
	public String work() {
		 System.out.println("学生学习...");
	     return "学习";
	}

	@Override
	public String say() {
		 System.out.println("学生说老师好...");
	     return "老师好";
	}

}
