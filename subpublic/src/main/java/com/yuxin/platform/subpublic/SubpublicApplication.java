package com.yuxin.platform.subpublic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yuxin.platform"})
public class SubpublicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubpublicApplication.class, args);
    }
}
