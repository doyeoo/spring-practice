package org.zerock.ex3.service;

import org.zerock.ex3.dto.PostDTO;
import org.zerock.ex3.domain.Post;

public interface PostService {
    Long write(PostDTO dto);

    //엔티티 객체 DTO로 변환
    default Post dtoToEntity(PostDTO dto) {
        Post entity = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        return entity;
    }
}
