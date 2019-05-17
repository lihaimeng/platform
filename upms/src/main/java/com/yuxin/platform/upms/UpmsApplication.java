package com.yuxin.platform.upms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

//@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.yuxin.platform"})
@ComponentScan(basePackages = {"com.yuxin.platform"})
//@EnableRedisHttpSession
public class UpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpmsApplication.class, args);
    }
}
