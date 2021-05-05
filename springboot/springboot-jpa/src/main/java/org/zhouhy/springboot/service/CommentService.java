package org.zhouhy.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhouhy.springboot.entity.Article;
import org.zhouhy.springboot.entity.Comment;
import org.zhouhy.springboot.repository.ArticleRepository;
import org.zhouhy.springboot.repository.CommentRepository;

import java.util.Optional;

@Slf4j
@Service
public class CommentService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;


    public void postComment(Long articleId, String content) {
        Optional<Article> articleOptional = articleRepository.findById(articleId);
        if (!articleOptional.isPresent()) {
            throw new RuntimeException("没有对应的文章");
        }
        Article article = articleOptional.get();

        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setContent(content);
        commentRepository.save(comment);

        article.setCommentCount(article.getCommentCount() + 1);
        articleRepository.save(article);
    }    
}
