package com.sustech.video_service.mapper;

import com.sustech.video_service.entity.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Insert("insert into t_video(url,title,brief,uploader,gmt_create,gmt_modified,cover,type,id) values(#{url},#{title},#{brief},#{uploader},#{gmt_create},#{gmt_modified},#{cover},#{type},#{id})")
    int addVideo(String id,String url,String title,String brief,String uploader,String cover,String gmt_create,String gmt_modified,String type);
    @Delete("delete from t_video where url=#{url}")
    int deleteVideo(String url);

    @Select("select * from t_video where id=#{id}")
    Video getVideoById(String id);

    @Select("select * from t_video")
    List<Video> getAll();

    @Select("select * from t_video where uploader=#{user_id}")
    List<Video> getUserByUserId(String user_id);

}
