package com.imooc.postprocessor.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

public class BeanFactoryPostProcessor_2 implements BeanFactoryPostProcessor, Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("调用了 BeanFactoryPostProcessor_1 ");

		BeanDefinition bd = beanFactory.getBeanDefinition("studentService");

		MutablePropertyValues propertyValues = bd.getPropertyValues();

		propertyValues.addPropertyValue("age",18);

	}

	@Override
	public int getOrder() {
		return 2;
	}
}
