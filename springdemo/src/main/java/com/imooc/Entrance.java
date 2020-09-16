package com.imooc;

import com.imooc.serivce.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author hailin.tang
 * @date 2020/9/5 6:40 下午
 * @function
 */
public class Entrance {
	public static void main(String[] args) {
		System.out.println("Hello World");
		String xmlPath = "//Users/aaron/Downloads/spring-framework-5.2.x/springdemo/src/main/resources/spring/spring-config.xml";

		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);
		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeService");
		welcomeService.sayHello("强大的Spring框架");
	}
}
