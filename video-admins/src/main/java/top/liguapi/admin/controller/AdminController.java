package top.liguapi.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;
import top.liguapi.admin.constant.RedisPrefix;
import top.liguapi.admin.entity.dto.AdminDTO;
import top.liguapi.admin.entity.pojo.Admin;
import top.liguapi.admin.service.AdminService;
import top.liguapi.admin.utils.JSONUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/13 17:43
 */
@RestController
@RequestMapping("admin")
@Slf4j
public class AdminController {

    private AdminService adminService;
    private RedisTemplate redisTemplate;

    @Autowired
    public AdminController(AdminService adminService, RedisTemplate redisTemplate) {
        this.adminService = adminService;
        this.redisTemplate = redisTemplate;
    }

    // 登录
    @RequestMapping("tokens")
    public Map<String, String> tokens(@RequestBody Admin admin, HttpSession session) {
        log.info("接收到admin对象为：{}", JSONUtils.writeValueAsString(admin));
        // 登录
        Admin adminDB = adminService.login(admin);
        // 登陆成功，保存token
        String token = session.getId();
        redisTemplate.opsForValue().set(RedisPrefix.TOKEN_KEY + token, adminDB, 30, TimeUnit.MINUTES);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

    // 用户信息
    @RequestMapping("admin-user")
    public AdminDTO adminInfo(String token) {
        log.info("当前token为：{}", token);
        Admin admin = (Admin) redisTemplate.opsForValue().get(RedisPrefix.TOKEN_KEY + token);
        AdminDTO adminDTO = new AdminDTO();
        BeanUtils.copyProperties(admin, adminDTO);
        return adminDTO;
    }

    // 注销登录
    @RequestMapping("/tokens/{token}")
    public void logout(@PathVariable("token") String token){
        redisTemplate.delete(RedisPrefix.TOKEN_KEY + token);
        log.info("注销成功！");
    }
}
