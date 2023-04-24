package com.fqh.springframework;

import com.fqh.springframework.LifeCycle.BeanVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFrameworkApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(SpringFrameworkApplication.class, args);
        var bean = context.getBean(BeanVO.class);
//        System.out.println(bean);

    }

}
