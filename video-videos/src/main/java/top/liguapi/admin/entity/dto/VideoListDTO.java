package top.liguapi.admin.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/14 16:20
 */
@Data
public class VideoListDTO {
    private Long total_count;
    private List<VideoItemsDTO> items;
}
