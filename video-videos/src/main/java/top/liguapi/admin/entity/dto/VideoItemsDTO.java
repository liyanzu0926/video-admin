package top.liguapi.admin.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/14 16:34
 */
@Data
public class VideoItemsDTO {
    private Integer id;

    private String title;

    private String cover;

    private String intro;

    private Integer uid;

    private String link;

    // 序列化和反序列化为：category_id
    @JsonProperty("category_id")
    private Integer categoryId;

    private String category;

    private UserDTO uploader;
}
