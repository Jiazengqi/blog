package com.example.blog.dao;

import com.example.blog.po.Comment;
import com.example.blog.po.CommentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CommentMapper {
    int countByExample(CommentCriteria example);

    int deleteByExample(CommentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExampleWithBLOBs(CommentCriteria example);

    List<Comment> selectByExample(CommentCriteria example);

    Comment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentCriteria example);

    int updateByExampleWithBLOBs(@Param("record") Comment record, @Param("example") CommentCriteria example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentCriteria example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}