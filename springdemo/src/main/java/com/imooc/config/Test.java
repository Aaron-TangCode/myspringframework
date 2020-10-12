package com.imooc.config;

import com.imooc.serivce.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");

		StudentService studentService = (StudentService) context.getBean("studentService");
		System.out.println("student name:" + studentService.getName());
	}
}
