package top.liguapi.admin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liguapi.admin.entity.dto.VideoItemsDTO;
import top.liguapi.admin.entity.dto.VideoListDTO;
import top.liguapi.admin.mapper.VideoMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lww
 * @Version 1.0
 * @Date 2022/5/14 14:40
 */
@Service
public class VideoServiceImpl implements VideoService {

    private VideoMapper videoMapper;

    @Autowired
    public VideoServiceImpl(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

    @Override
    public VideoListDTO query(Integer page, Integer size, String id, String name, String categoryId, String up) {
        PageHelper.startPage(page, size);
        List<VideoItemsDTO> videoItemsDTOList = videoMapper.query(id, name, categoryId, up);
        PageInfo<VideoItemsDTO> videoItemsDTOPageInfo = new PageInfo<>(videoItemsDTOList);
        long total = videoItemsDTOPageInfo.getTotal();
        VideoListDTO videoListDTO = new VideoListDTO();
        videoListDTO.setTotal_count(total);
        videoListDTO.setItems(videoItemsDTOList);
        return videoListDTO;
    }
}
