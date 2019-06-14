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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@Valid @RequestBody PostRequestDto dto, BindingResult result) {

        // validation 오류 발생
        if (result.hasErrors()) {
            throw new PostProcessingException("[생성] 포스터 등록에 관한 데이터가 누락되었습니다.");
        }

        log.debug(dto.toString());

        final Post savedPost = postService.save(dto);

        return ResponseEntity.ok().body(savedPost);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAll() {

        final List<Post> posts = postService.findAll();

        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable(value="id") Long id){

        final Post foundPost = postService.findById(id);

        return ResponseEntity.ok().body(foundPost);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable(value="id") Long id,
                                           @Valid @RequestBody PostRequestDto dto,
                                           BindingResult result){

        if(result.hasErrors()){
            throw new PostProcessingException("포스터 수정에 관한 데이터가 누락되었습니다.");
        }

        log.debug(dto.toString());

        final Post updatedPost = postService.updatePost(id, dto);

        return ResponseEntity.ok().body(updatedPost);
    }

    @DeleteMapping("/posts/{id}")
    public Map<String, Boolean> deletePost(@PathVariable(value="id") Long id){

        postService.deletePost(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

}
