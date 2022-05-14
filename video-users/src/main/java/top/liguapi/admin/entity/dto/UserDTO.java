package top.liguapi.admin.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/14 13:58
 */
@Data
public class UserDTO {
    private Integer id;

    private String name;

    private String avatar;

    private String intro;

    private String phone;

    // 序列化和反序列化为：phone_linked
    @JsonProperty("phone_linked")
    private Boolean phoneLinked;

    private String openid;

    // 序列化和反序列化为：wechat_linked
    @JsonProperty("wechat_linked")
    private Boolean wechatLinked;
}
