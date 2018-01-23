package com.chinaYouthHealth.payment.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @auther Administrator
 * @date 2017/9/21
 */
@SpringBootApplication
@ComponentScan("com.dingPeng")
public class PaymentManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
