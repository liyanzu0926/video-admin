package top.liguapi.admin.service;

import top.liguapi.admin.entity.dto.VideoListDTO;

import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/14 14:39
 */
public interface VideoService {
    VideoListDTO query(Integer page, Integer size, String id, String name, String categoryId, String up);
}
