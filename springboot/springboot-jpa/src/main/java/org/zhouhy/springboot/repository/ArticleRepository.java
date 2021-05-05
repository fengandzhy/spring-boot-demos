package org.zhouhy.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.zhouhy.springboot.entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    
}
