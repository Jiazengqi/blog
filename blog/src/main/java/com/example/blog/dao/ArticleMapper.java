package com.example.blog.dao;

import com.example.blog.po.Article;
import com.example.blog.po.ArticleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ArticleMapper {
    int countByExample(ArticleCriteria example);

    int deleteByExample(ArticleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleCriteria example);

    List<Article> selectByExample(ArticleCriteria example);

    Article selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> queryFirstArticle();
}