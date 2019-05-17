package com.yuxin.platform.zongzhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.yuxin.platform"})
@ComponentScan(basePackages = {"com.yuxin.platform"})
//@EnableEurekaClient
//@EnableRedisHttpSession
public class ZongzhiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZongzhiApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

