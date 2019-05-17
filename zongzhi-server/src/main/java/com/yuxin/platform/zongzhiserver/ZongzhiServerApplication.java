package com.yuxin.platform.zongzhiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yuxin.platform"})
@MapperScan(basePackages = {"com.yuxin.platform.*.mapper", "com.yuxin.platform.*.*.mapper"})
public class ZongzhiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZongzhiServerApplication.class, args);
    }
}
