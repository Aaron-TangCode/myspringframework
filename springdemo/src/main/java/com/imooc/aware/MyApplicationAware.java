package com.imooc.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;

public class MyApplicationAware implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware {
	private String beanName;

	private BeanFactory beanFactory;

	private ClassLoader classLoader;

	private ApplicationContext applicationContext;

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("调用了 BeanClassLoaderAware 的 setBeanClassLoader 方法");
		this.classLoader = classLoader;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用了 BeanClassLoaderAware 的 setBeanFactory 方法");
		this.beanFactory = beanFactory;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("调用了 BeanNameAware 的 setBeanName 方法");
		this.beanName = beanName;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("调用了 ApplicationContextAware 的 setApplicationContext方法");
		this.applicationContext = applicationContext;
	}
	public void display(){
		System.out.println("beanName:" + beanName);
		System.out.println("是否为单例：" + beanFactory.isSingleton(beanName));
		System.out.println("系统环境为：" + applicationContext.getEnvironment());
	}

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("/spring/spring-config.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);

		MyApplicationAware applicationAware = (MyApplicationAware) factory.getBean("myApplicationAware");
		applicationAware.display();
	}
}
