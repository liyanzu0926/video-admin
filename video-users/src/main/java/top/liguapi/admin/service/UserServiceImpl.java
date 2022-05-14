package top.liguapi.admin.service;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liguapi.admin.entity.dto.UserDTO;
import top.liguapi.admin.entity.dto.UserListDTO;
import top.liguapi.admin.entity.pojo.User;
import top.liguapi.admin.entity.pojo.UserExample;
import top.liguapi.admin.mapper.UserMapper;

import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/14 12:57
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserListDTO query(Integer page, Integer size, Integer id, String name, String phone) {
        // 开启分页
        PageHelper.startPage(page, size);
        UserExample example = new UserExample();
        if (id != null){
            example.createCriteria().andIdEqualTo(id);
        }
        if (name != null){
            example.createCriteria().andNameEqualTo(name);
        }
        if (phone != null){
            example.createCriteria().andPhoneEqualTo(phone);
        }
        // 获取user list
        List<User> users = userMapper.selectByExample(example);
        // 从pageinfo中获取total
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        long total = userPageInfo.getTotal();
        // 使用糊涂包提供的bean集合类复制api
        List<UserDTO> userDTOS = BeanUtil.copyToList(users, UserDTO.class);
        UserListDTO userListDTO = new UserListDTO();
        userListDTO.setTotal_count(total);
        userListDTO.setItems(userDTOS);
        return userListDTO;
    }
}
