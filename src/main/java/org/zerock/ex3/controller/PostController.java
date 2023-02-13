package org.zerock.ex3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.ex3.service.PostService;
import org.zerock.ex3.dto.PostDTO;

import java.util.List;

@Controller
@RequestMapping("/posts")
@Log4j2
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @PostMapping("/")
    public ResponseEntity<Long> write(@RequestBody PostDTO postDTO) {
        log.info(postDTO);

        Long num = service.write(postDTO);

        return new ResponseEntity<>(num, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<PostDTO>> getPost() {
        List<PostDTO> result = service.getPostList();
        System.out.println(result);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
