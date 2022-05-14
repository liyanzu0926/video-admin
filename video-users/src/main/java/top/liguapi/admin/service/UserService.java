package top.liguapi.admin.service;

import top.liguapi.admin.entity.dto.UserListDTO;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/14 12:56
 */
public interface UserService {
    UserListDTO query(Integer page, Integer size, Integer id, String name, String phone);
}
