package org.zhouhy.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="comment_count")
    private Long commentCount;    
}
