package org.zerock.ex3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex3.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
}
