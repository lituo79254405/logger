package com.tall.logger;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 *
 * @author tall
 * @date 2019/11/13
 */
@SpringBootApplication(scanBasePackages = {"com.tall.logger.*"})
public class LoggerApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(LoggerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args){
        System.out.println("项目启动成功");
    }
}
