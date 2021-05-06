package org.zhouhy.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.service.CommentService;

@Slf4j
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("comment")
    public String comment(Long articleId, String content) {        
        try {
            commentService.postComment(articleId, content);
        } catch (Exception e) {
            log.error("{}", e);
            return "error: " + e.getMessage();
        }
        return "success";
    }
}
