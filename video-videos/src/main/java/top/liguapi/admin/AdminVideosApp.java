package top.liguapi.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/12 21:10
 */
@SpringBootApplication
@MapperScan("top.liguapi.admin.mapper")
public class AdminVideosApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminVideosApp.class, args);
    }
}
