package com.ostapenkodmytro.javacore.controller;

import com.ostapenkodmytro.javacore.enums.PostStatus;
import com.ostapenkodmytro.javacore.model.Label;
import com.ostapenkodmytro.javacore.model.Post;
import com.ostapenkodmytro.javacore.repository.PostRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    public Post createPost(String content, String created, String updated, List<Label> labels, PostStatus status) {
        Post newPost = Post.builder()
                .content(content)
                .created(created)
                .updated(updated)
                .labels(labels)
                .postStatus(status)
                .build();
        return postRepository.save(newPost);
    }

    public Post getPostById(Long id) {
        return postRepository.getById(id);
    }

    public List<Post> getAllPost() {
        return postRepository.getAll();
    }

    public Post updatePost(Long id, String content, String created, String updated, List<Label> labels, PostStatus status) {
        Post updatePost = Post.builder()
                .content(content)
                .created(created)
                .updated(updated)
                .labels(labels)
                .postStatus(status)
                .build();
        updatePost.setId(id);
        return postRepository.update(updatePost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
