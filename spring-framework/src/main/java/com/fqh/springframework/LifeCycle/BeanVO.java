package com.fqh.springframework.LifeCycle;

import org.springframework.beans.factory.*;

public class BeanVO implements BeanFactoryAware, BeanNameAware,
        InitializingBean, DisposableBean {

    private Integer id;
    private String info;

    private BeanFactory beanFactory;
    private String beanName;

    public BeanVO() {
        System.out.println("[构造器] 调用 BeanVO的构造器实例化");
    }

    public BeanVO(Integer id, String info) {
        this.id = id;
        this.info = info;
        System.out.println("[构造器] 调用 BeanVO的构造器实例化");
    }

    public void setId(Integer id) {
        System.out.println("[BeanVO] 属性赋值阶段 ===> 调用setId()方法");
        this.id = id;
    }

    public void setInfo(String info) {
        System.out.println("[BeanVO] 属性赋值阶段 ===> 调用setInfo()方法");
        this.info = info;
    }

    //===============================================扩展接口==========================================
    // BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println("[BeanFactoryAware接口] 调用setBeanFactory()方法");
        this.beanFactory = beanFactory;
    }
    // BeanNameAware接口方法
    @Override
    public void setBeanName(String beanName) {
        System.out.println("[BeanNameAware] 调用setBeanName()方法");
        this.beanName = beanName;
    }
    // InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[InitializingBean] 初始化阶段 ===> 调用afterPropertiesSet()方法");
    }
    // DisposableBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("[DisposableBean] 容器关闭接口 ===> 调用destroy()方法");
    }
    //===================================================================================================

    @Override
    public String toString() {
        return "BeanVO{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
