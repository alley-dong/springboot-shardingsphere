package com.mashibing.shardingproxydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mashibing.shardingproxydemo.mapper")
public class ShardingproxyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingproxyDemoApplication.class, args);
    }

}
