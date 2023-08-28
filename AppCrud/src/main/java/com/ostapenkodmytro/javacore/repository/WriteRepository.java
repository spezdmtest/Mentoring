package com.ostapenkodmytro.javacore.repository;

import com.ostapenkodmytro.javacore.model.Post;

import java.io.Writer;

public interface WriteRepository extends GenericRepository<Writer, Long> {
    Writer addPostToWriter(Long writerId, Post post);
}
