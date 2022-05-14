package top.liguapi.admin.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/13 20:12
 */
@Data
public class AdminDTO {

    // 序列化和反序列化为：name
    @JsonProperty("name")
    private String username;
    private String avatar;
}
