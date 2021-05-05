package org.zhouhy.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.zhouhy.springboot.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
