package com.staxrt.tutorial.post;

import com.staxrt.tutorial.exception.PostProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    Post save(PostRequestDto dto) {

        Post post = dto.toEntity();

        return postRepository.save(post);
    }

    List<Post> findAll() {

        final List<Post> posts = postRepository.findAll();

        if (posts.size() == 0) {
            throw new PostProcessingException("포스터가 하나도 등록되지 않았습니다.");
        }

        return posts;
    }

    Post findById(Long id){

        final Post foundPost = postRepository
                .findById(id)
                .orElseThrow(() -> new PostProcessingException(id + " 에 대한 포스터가 존재하지 않습니다"));

        return foundPost;
    }

    Post updatePost(Long id, PostRequestDto dto) {

        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new PostProcessingException(id + " 에 대한 포스터가 존재하지 않습니다"));

        post.updateContent(dto.getContent());

        return postRepository.save(post);
    }

    void deletePost(Long id){

        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new PostProcessingException(id + " 에 대한 포스터가 존재하지 않습니다"));

        postRepository.deleteById(id);
    }

}
