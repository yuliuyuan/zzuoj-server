package cn.edu.zzu.oj;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("cn.edu.zzu.oj.mapper")
@SpringBootApplication(scanBasePackages = {"cn.edu.zzu.oj"})
@EnableEurekaClient
@EnableFeignClients
public class ProblemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProblemApplication.class, args);
    }
}
