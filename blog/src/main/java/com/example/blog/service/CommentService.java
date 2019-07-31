package com.example.blog.service;

import com.example.blog.dao.CommentMapper;
import com.example.blog.po.Comment;
import com.example.blog.po.CommentCriteria;
import com.example.blog.util.CreateIdUtil;
import com.example.blog.util.ResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> findCommentByAid(String acId){
        CommentCriteria commentCriteria=new CommentCriteria();
        commentCriteria.createCriteria().andArticleIdEqualTo(acId);
        List<Comment> list=commentMapper.selectByExample(commentCriteria);
        return list;
    }

    public ResultList addComment(Comment comment){
        ResultList resultList=new ResultList();
        comment.setId(CreateIdUtil.getAcId("Co"));
        comment.setCreateAt(new Timestamp(System.currentTimeMillis()));
        int a=commentMapper.insert(comment);
        if(a>0){
            resultList.setStatus("500");
            resultList.setMsg("添加成功");
        }else {
            resultList.setMsg("添加失败");
        }
        return resultList;
    }
}
