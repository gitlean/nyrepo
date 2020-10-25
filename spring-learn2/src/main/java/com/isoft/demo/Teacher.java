package com.isoft.demo;
/**
*@author anonymous
*@createTime 2020年10月25日 上午9:59:15
*@describe
*/
public class Teacher implements People {

	@Override
	public String work() {
		 System.out.println("老师教书育人...");
	     return "教书";
	}

	@Override
	public String say() {
		System.out.println("老师说好好学习...");
	    return "好好学习";
	}

}
