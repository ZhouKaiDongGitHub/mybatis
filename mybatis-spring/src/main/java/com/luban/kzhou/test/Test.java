package com.luban.kzhou.test;

import com.luban.kzhou.annotation.AppConfig;
import com.luban.kzhou.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.handleOrderInfoById("1");*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        OrderService orderService = context.getBean(OrderService.class);
        orderService.handleOrderInfoById("1");

    }
}
