package org.zerock.ex3.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex3.dto.PostDTO;
import org.zerock.ex3.domain.Post;

@SpringBootTest
public class PostServiceTests {

    @Autowired
    private PostService service;

    @Test
    public void testWrite() {
        PostDTO postDTO = PostDTO.builder()
                .title("title")
                .content("content")
                .build();
        System.out.println(service.write(postDTO));
    }
}
