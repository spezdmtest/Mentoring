package com.ostapenkodmytro.javacore.controller;

import com.ostapenkodmytro.javacore.enums.PostStatus;
import com.ostapenkodmytro.javacore.model.Label;
import com.ostapenkodmytro.javacore.model.Post;
import com.ostapenkodmytro.javacore.repository.PostRepository;
import lombok.RequiredArgsConstructor;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    public Post createPost(String content, String created, String updated, List<Label> labels, PostStatus status) {
        Post newPost = new Post(content, created, updated, labels, status);
        return postRepository.save(newPost);
    }

    public Post getPostById(Long id) throws FileNotFoundException {
        return postRepository.getById(id);
    }

    public List<Post> getAllPost() {
        return postRepository.getAll();
    }

    public Post updatePost(Long id, String content, String created, String updated, List<Label> labels, PostStatus status) {
        Post updatePost = new Post(content, created, updated, labels, status);
        updatePost.setId(id);
        return postRepository.update(updatePost);
    }

    public void deletePost(Long id) throws FileNotFoundException {
        postRepository.deleteById(id);
    }
}
