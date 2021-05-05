package org.zhouhy.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="article_Id")
    private Long articleId;
    private String content;    
}
