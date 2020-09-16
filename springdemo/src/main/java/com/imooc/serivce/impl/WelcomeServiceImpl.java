package com.imooc.serivce.impl;

import com.imooc.serivce.WelcomeService;

/**
 * @author hailin.tang
 * @date 2020/9/5 6:43 下午
 * @function
 */
public class WelcomeServiceImpl implements WelcomeService {
	@Override
	public String sayHello(String name) {
		System.out.println("hello "+name);
		return "success";
	}
}
