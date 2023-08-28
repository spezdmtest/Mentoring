package com.ostapenkodmytro.javacore.repository;

import com.ostapenkodmytro.javacore.model.Label;
import com.ostapenkodmytro.javacore.model.Post;

public interface PostRepository extends GenericRepository<Post, Long> {
    Post addLabeltoPost(Long postId, Label label);
}
