package org.zerock.ex3.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.ex3.domain.Post;
import org.zerock.ex3.dto.PostDTO;
import org.zerock.ex3.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    //final로 선언하면 값 변경 불가

    @Override
    public Long write(PostDTO dto) {

        log.info("-----DTO-----");
        log.info(dto);

        Post entity = dtoToEntity(dto);

        log.info("-----ETT-----");
        log.info(entity);

        repository.save(entity);

        return entity.getId();
    }

    public List<PostDTO> getPostList() {
        List<Post> result = repository.findAll();

        return result.stream().map(post -> entityToDTO(post)).collect(Collectors.toList());
    }
}
