package top.liguapi.admin.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/13 20:51
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // 只返回不为空的参数
public class CategoryDTO {
    private Integer id;
    private String name;
    private Integer parentId;
    private List<CategoryDTO> children;
}
