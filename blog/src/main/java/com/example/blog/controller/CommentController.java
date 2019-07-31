package com.example.blog.controller;

import com.example.blog.po.Comment;
import com.example.blog.po.CommentCriteria;
import com.example.blog.service.CommentService;
import com.example.blog.util.CreateIdUtil;
import com.example.blog.util.ResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/comment/find")
    public List<Comment> findCommentByAid(@RequestParam("acId")String acId){
        return commentService.findCommentByAid(acId);
    }

    @RequestMapping("/comment/1")
    public ResultList addComment(Comment comment){
        System.out.println(comment);
        return commentService.addComment(comment);
    }
}
