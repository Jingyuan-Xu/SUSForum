package com.sustech.video_service.mapper;

import com.sustech.video_service.entity.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoMapper {

    @Insert("insert into t_video values(#{id},#{url},#{title},#{brief},#{uploader},#{gmt_create},#{gmt_modified},#{cover},#{type})")
    int addVideo(String id,String url,String title,String brief,String uploader,String cover,String gmt_create,String gmt_modified,String type);
    @Delete("delete from t_video where url=#{url}")
    int deleteVideo(String url);

    @Select("select * from t_video where id=#{id}")
    Video getVideoById(String id);

}
