package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.Post;
import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostRepository postRepository;

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post, BindingResult result) {

        // validation 오류 발생
        if(result.hasErrors()){
            log.debug("에러발생");
        }

        final Post savedPost = postRepository.save(post);

        return ResponseEntity.ok(savedPost);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAll() throws ResourceNotFoundException {

        List<Post> posts = postRepository.findAll();

        if(posts.size() == 0){
            throw new ResourceNotFoundException("All Post not found");
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(posts);
    }



}
