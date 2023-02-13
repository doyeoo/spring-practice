package org.zerock.ex3.service;

import org.zerock.ex3.dto.PostDTO;
import org.zerock.ex3.domain.Post;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO dto);
    List<PostDTO> getPostList();

    //엔티티 객체 DTO로 변환
    default Post dtoToEntity(PostDTO dto) {
        Post entity = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        return entity;
    }

    default PostDTO entityToDTO(Post post) {
        PostDTO postDTO = PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();

        return postDTO;
    }
}
