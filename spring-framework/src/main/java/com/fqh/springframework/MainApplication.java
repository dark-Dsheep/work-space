package com.fqh.springframework;

import com.fqh.springframework.LifeCycle.BeanVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(MainApplication.class, args);
        var bean = context.getBean(BeanVO.class);
//        System.out.println(bean);

    }

}
