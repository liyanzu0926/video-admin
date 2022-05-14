package top.liguapi.admin.mapper;

import org.apache.ibatis.annotations.Param;
import top.liguapi.admin.entity.dto.VideoItemsDTO;
import top.liguapi.admin.entity.pojo.Video;
import top.liguapi.admin.entity.pojo.VideoExample;

import java.util.List;

public interface VideoMapper {
    long countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    List<VideoItemsDTO> query(@Param("id") String id, @Param("name") String name, @Param("categoryId") String categoryId, @Param("up") String up);
}