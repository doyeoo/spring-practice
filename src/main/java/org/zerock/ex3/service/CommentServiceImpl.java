package org.zerock.ex3.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.ex3.domain.Comment;
import org.zerock.ex3.domain.Post;
import org.zerock.ex3.dto.CommentDTO;
import org.zerock.ex3.repository.CommentRepository;
import org.zerock.ex3.repository.PostRepository;

@Service
@Log4j2
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO, Long postId) {
        Post post = postRepository.getReferenceById(postId);
        Comment comment = dtoToEntity(commentDTO, post);
        commentRepository.save(comment);

        return entityToDTO(comment);
    }

}
