package com.sustech.video_service.mapper;

import com.sustech.video_service.entity.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoMapper {

    @Insert("insert into t_video values(#{url},#{title},#{brief},#{uploader},#{gmt_create},#{gmt_modified})")
    int addVideo(String url,String title,String brief,String uploader,String gmt_create,String gmt_modified);

    @Delete("delete from t_video where url=#{url}")
    int deleteVideo(String url);

    @Select("select * from t_video where url=#{url}")
    Video getVideoByURL(String url);

}
