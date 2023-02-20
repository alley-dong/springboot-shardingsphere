package com.mashibing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author spikeCong
 * @date 2022/11/22
 **/
@EnableTransactionManagement  //开启声明式事务
@SpringBootApplication
@MapperScan("com.mashibing.mapper")
public class ShardingTransApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShardingTransApplication.class,args);
    }
}
