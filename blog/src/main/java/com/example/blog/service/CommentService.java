package com.example.blog.service;

import com.example.blog.dao.CommentMapper;
import com.example.blog.po.Comment;
import com.example.blog.po.CommentCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
