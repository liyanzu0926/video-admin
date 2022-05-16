package top.liguapi.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.liguapi.admin.entity.pojo.Admin;
import top.liguapi.admin.entity.pojo.AdminExample;
import top.liguapi.admin.exception.AdminsException;
import top.liguapi.admin.exception.AdminsExceptionEnum;
import top.liguapi.admin.mapper.AdminMapper;

import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/13 17:44
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        // 判断用户名
        if (admins == null || admins.size() == 0) throw new AdminsException(AdminsExceptionEnum.USERNAME_ERROR);
        // 判断密码
        String password = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
        if (!password.equals(admins.get(0).getPassword())) throw new AdminsException(AdminsExceptionEnum.PASSWORD_ERROR);
        return admins.get(0);
    }
}
