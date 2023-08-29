package com.ostapenkodmytro.javacore.view;

import com.ostapenkodmytro.javacore.controller.LabelController;
import com.ostapenkodmytro.javacore.controller.PostController;
import com.ostapenkodmytro.javacore.enums.PostStatus;
import com.ostapenkodmytro.javacore.model.Label;
import com.ostapenkodmytro.javacore.model.Post;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;


public class PostView {

    private final PostController postController;
    private final LabelController labelController;
    private final Scanner scanner;

    public PostView(PostController postController,
                    LabelController labelController) {
        this.postController = postController;
        this.scanner = new Scanner(System.in);
        this.labelController = labelController;
    }


    public void run() throws FileNotFoundException {
        boolean running = true;

        while (running) {
            System.out.println("1. Create Post");
            System.out.println("2. Get post by ID.");
            System.out.println("3. Get All Posts.");
            System.out.println("4. Update Post");
            System.out.println("5. Delete Post");
            System.out.println("6. Exit");
            System.out.println("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> createPost();
                case 2 -> getPostById();
                case 3 -> getAllPosts();
                case 4 -> updatePost();
                case 5 -> deletePost();
                case 6 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void getPostById() {
        System.out.println("Enter Label id: ");
        long id = scanner.nextLong();
        Post post = postController.getPostById(id);
        System.out.println("Post found: " + post);
    }


    public Post createPost() {
        System.out.println("Enter content: ");
        String content = scanner.nextLine();
        PostStatus status = PostStatus.ACTIVE;
        String createTime = LocalDateTime.now().toString();
        List<Label> labels = labelController.getALLLabels();
        Post newPost = postController.createPost(content, createTime, null, labels, status);
        System.out.println("Post created with ID: " + newPost.getId());
        return newPost;
    }

    public void getAllPosts() {
        System.out.println("All Posts: ");
        postController.getAllPost()
                .forEach(System.out::println);
    }

    public void updatePost() {
        System.out.println("Enter Post id to update: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter update content: ");
        String content = scanner.nextLine();
        PostStatus status = PostStatus.ACTIVE;
        String updatedTime = LocalDateTime.now().toString();
        List<Label> labels = labelController.getALLLabels();
        Post postById = postController.getPostById(id);
        String created = postById.getCreated();
        Post updatedPost = postController.updatePost(id, content, created, updatedTime, labels, status);
        System.out.println("Post updated with ID: " + updatedPost);
    }

    public void deletePost() {
        System.out.println("Enter post ID to delete: ");
        long id = scanner.nextLong();
        postController.deletePost(id);
        System.out.println("Post deleted.");
    }
}

