package com.staxrt.tutorial.post;

import com.staxrt.tutorial.model.Post;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@ToString
public class PostRequestDto implements Serializable {

    @NotBlank
    String content;

    Post toEntity(){
        return Post.builder()
                .content(content)
                .build();
    }
}
