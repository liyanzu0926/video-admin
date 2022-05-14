package top.liguapi.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.liguapi.admin.entity.dto.UserListDTO;
import top.liguapi.admin.service.UserService;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/14 12:56
 */
@RestController
@RequestMapping("admin")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public UserListDTO userList(Integer page, @RequestParam("per_page") Integer size, Integer id, String name, String phone){
        return userService.query(page, size, id, name, phone);
    }
}
