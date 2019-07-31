package com.example.blog.service;

import com.example.blog.dao.ArticleMapper;
import com.example.blog.po.Article;
import com.example.blog.po.ArticleCriteria;
import com.example.blog.util.CreateIdUtil;
import com.example.blog.util.ResultList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    //首页
    public PageInfo<Article> firstArticle(){

        PageHelper.startPage(1,10);
        List<Article> list=articleMapper.queryFirstArticle();
        for(Article a:list){
            a.setContent("");
        }
        return new PageInfo<>(list);
    }
    //文章列表
    public PageInfo<Article> queryArticle(Integer page){

        PageHelper.startPage(page,10);
        List<Article> list=articleMapper.queryFirstArticle();
        return new PageInfo<>(list);
    }


    //根据id查找article
    public Article queryArticlebyId(String id){
        return articleMapper.selectByPrimaryKey(id);

    }

    public ResultList addArticle(Article article){
        ResultList resultList=new ResultList();
        article.setId(CreateIdUtil.getAcId("A"));
        article.setCreateAt(new Timestamp(System.currentTimeMillis()));
       int a= articleMapper.insert(article);
       if(a>0){
           resultList.setMsg("添加成功");
       }else{
           resultList.setMsg("添加失败");
           resultList.setStatus("500");
       }
       return resultList;
    }

    //修改
    public ResultList modifyArticle(Article article){
        ResultList resultList=new ResultList();
        article.setCreateAt(new Timestamp(System.currentTimeMillis()));
       int a= articleMapper.updateByPrimaryKeySelective(article);
       if(a>0){
           resultList.setStatus("500");
           resultList.setMsg("修改成功");
       }else {
           resultList.setMsg("修改失败");
       }
       return resultList;
    }
}
