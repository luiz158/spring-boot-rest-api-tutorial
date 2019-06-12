package com.staxrt.tutorial.post;

import com.staxrt.tutorial.exception.PostProcessingException;
import com.staxrt.tutorial.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final PostService postService;
    private final PostRepository postRepository;

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@Valid @RequestBody PostRequestDto dto,
                                           BindingResult result) {

        // validation 오류 발생
        if(result.hasErrors()){
            throw new PostProcessingException("포스터 등록에 관한 데이터가 누락되었습니다.");
        }

        log.debug(dto.toString());

        final Post savedPost = postService.save(dto);

        return ResponseEntity.ok().body(savedPost);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAll() throws ResourceNotFoundException {

        List<Post> posts = postRepository.findAll();

        if(posts.size() == 0){
            throw new ResourceNotFoundException("All Post not found");
        }

        return ResponseEntity.ok().body(posts);
    }



}
