package org.zhouhy.springboot.repository;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.zhouhy.springboot.entity.Article;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    
    @Query(value = "select * from t_article a where a.id = :id for update", nativeQuery = true)
    Optional<Article> findArticleForUpdate(@Param("id")Long id);

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("select a from Article a where a.id = :id")
    Optional<Article> findArticleWithPessimisticLock(@Param("id")Long id);

    @Override
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    Optional<Article> findById(Long id);
    
    
}
