package com.staxrt.tutorial.repository;

import com.staxrt.tutorial.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
