package top.liguapi.admin.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/14 13:11
 */
@Data
public class UserListDTO {
    private Long total_count;
    private List<UserDTO> items;
}
