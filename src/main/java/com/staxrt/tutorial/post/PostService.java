package com.staxrt.tutorial.post;

import com.staxrt.tutorial.model.Post;
import com.staxrt.tutorial.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post save(PostRequestDto dto){

        Post post = dto.toEntity();

        return postRepository.save(post);
    }

}
