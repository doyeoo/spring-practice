package org.zerock.ex3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.ex3.service.PostService;
import org.zerock.ex3.service.CommentService;
import org.zerock.ex3.dto.PostDTO;
import org.zerock.ex3.dto.CommentDTO;

import java.util.List;

@Controller
@RequestMapping("/posts")
@Log4j2
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("/")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        log.info(postDTO);

        PostDTO result = postService.createPost(postDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<PostDTO>> getPost() {
        List<PostDTO> result = postService.getPostList();
        System.out.println(result);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/{postId}")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO, @PathVariable("postId") Long postId) {
        log.info(postId);
        CommentDTO result = commentService.createComment(commentDTO, postId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
