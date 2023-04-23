package com.fqh.springframework.LifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("调用 MyBeanPostProcessor构造器");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanVO")) {
            System.out.println("[MyBeanPostProcessor] 初始化前阶段 ===> postProcessBeforeInitialization()方法");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanVO")) {
            System.out.println("[MyBeanPostProcessor] 初始化后阶段 ===> 执行postProcessAfterInitialization()方法");
        }
        return bean;
    }


}
