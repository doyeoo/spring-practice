package org.zerock.ex3.service;

import org.zerock.ex3.domain.Comment;
import org.zerock.ex3.domain.Post;
import org.zerock.ex3.dto.CommentDTO;

public interface CommentService {

    CommentDTO createComment(CommentDTO commentDTO, Long postId);

    default Comment dtoToEntity(CommentDTO commentDTO, Post post) {
        Comment entity = Comment.builder()
                .post(post)
                .content(commentDTO.getContent())
                .build();

        return entity;
    }

    default CommentDTO entityToDTO(Comment comment) {
        CommentDTO commentDTO = CommentDTO.builder()
                .id(comment.getId())
                .postId(comment.getPost().getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();

        return commentDTO;
    }
}
