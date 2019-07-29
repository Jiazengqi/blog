package com.example.blog.controller;

import com.example.blog.po.Comment;
import com.example.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/findCoByAid")
    public List<Comment> findCommentByAid(@RequestParam("acId")String acId){
        return commentService.findCommentByAid(acId);
    }
}
