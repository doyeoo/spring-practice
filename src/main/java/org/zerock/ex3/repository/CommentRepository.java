package org.zerock.ex3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex3.domain.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long> {
}
