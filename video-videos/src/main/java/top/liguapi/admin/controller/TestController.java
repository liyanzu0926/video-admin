package top.liguapi.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/12 22:07
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("test")
    public String Test(){
        log.info("videos");
        return "videos";
    }
}
