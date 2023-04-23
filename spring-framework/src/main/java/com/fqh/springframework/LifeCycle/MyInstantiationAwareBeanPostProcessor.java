package com.fqh.springframework.LifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;


public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    // 实例化前
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equals("beanVO")) {
            System.out.println("[MyInstantiationAwareBeanPostProcessor] 实例化前阶段 ===> 调用postProcessBeforeInstantiation()方法");
        }
        return null;
    }

    // 实例化后
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanVO")) {
            System.out.println("[MyInstantiationAwareBeanPostProcessor] 实例化后阶段 ===> 调用postProcessAfterInstantiation()方法");
        }
        return true;
    }

    // 属性赋值
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanVO")) {
            System.out.println("[MyInstantiationAwareBeanPostProcessor] 属性赋值阶段 ===> 调用postProcessProperties()方法");
        }
        return pvs;
    }

}
