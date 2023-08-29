package com.ostapenkodmytro.javacore.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ostapenkodmytro.javacore.enums.PostStatus;
import com.ostapenkodmytro.javacore.model.Post;
import com.ostapenkodmytro.javacore.repository.PostRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonPostRepositoryImpl implements PostRepository {

    private static final String FILE_PATH = "C:/Users/spezdm/IdeaProjects/Mentoring/AppCrud/src/main/resources/posts.json";
    private final Gson gson = new Gson();

    public GsonPostRepositoryImpl() {
        loadPosts();
    }

    @Override
    public Post getById(Long id) {
        return loadPosts().stream()
                .filter(post -> post.getId().equals(id))
                .findFirst().orElse(new Post());
    }

    @Override
    public List<Post> getAll() {
        return loadPosts();
    }

    @Override
    public Post save(Post post) {
        List<Post> currentPosts = loadPosts();
        long nextId = currentPosts.stream()
                .mapToLong(Post::getId)
                .max().orElse(0) + 1;
        post.setId(nextId);
        currentPosts.add(post);
        savePosts(currentPosts);
        return post;
    }

    @Override
    public Post update(Post updatePost) {
        List<Post> currentPosts = loadPosts();
        List<Post> posts = updatedPosts(currentPosts, updatePost);
        savePosts(posts);
        return updatePost;
    }

    @Override
    public void deleteById(Long id) {
        List<Post> currentPosts = loadPosts();
        Post post = currentPosts.stream()
                .filter(existingPost ->
                        existingPost.getId().equals(id))
                .findFirst().orElse(new Post());
        post.setPostStatus(PostStatus.DELETED);
        savePosts(currentPosts);
    }

    private List<Post> loadPosts() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Post>>() {
            }.getType();
            List<Post> posts = gson.fromJson(reader, type);
            if (posts == null) {
                posts = new ArrayList<>();
            }
            return posts;

        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void savePosts(List<Post> posts) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(posts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Post> updatedPosts(List<Post> currentPosts, Post updatePost) {
        return currentPosts.stream()
                .map(existingPost -> {
                    if (existingPost.getId().equals(updatePost.getId())) {
                        return updatePost;
                    }
                    return existingPost;
                }).toList();
    }
}
