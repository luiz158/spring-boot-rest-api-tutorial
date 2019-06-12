package com.staxrt.tutorial.post;

import com.staxrt.tutorial.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
