package top.liguapi.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.liguapi.admin.entity.dto.VideoListDTO;
import top.liguapi.admin.service.VideoService;

import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/14 14:39
 */
@RestController
@RequestMapping("admin")
@Slf4j
public class VideoController {

    private VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("videos")
    public VideoListDTO videoList(@RequestParam("page") Integer page,
                                  @RequestParam("per_page") Integer size,
                                  @RequestParam(value = "id", required = false) String id,
                                  @RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "category_id", required = false) String categoryId,
                                  @RequestParam(value = "uploader_name", required = false) String up) {
        return videoService.query(page, size, id, name, categoryId, up);
    }
}
