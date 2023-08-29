package com.ostapenkodmytro.javacore.view;

import com.ostapenkodmytro.javacore.controller.PostController;
import com.ostapenkodmytro.javacore.controller.WriterController;
import com.ostapenkodmytro.javacore.enums.Status;
import com.ostapenkodmytro.javacore.model.Post;
import com.ostapenkodmytro.javacore.model.Writer;

import java.util.List;
import java.util.Scanner;


public class WriterView {

    private final PostController postController;
    private final WriterController writerController;
    private final Scanner scanner;

    public WriterView(PostController postController, WriterController writerController) {
        this.postController = postController;
        this.writerController = writerController;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("1. Create Writer");
            System.out.println("2. Get writer by ID.");
            System.out.println("3. Get All Writer.");
            System.out.println("4. Update Writer");
            System.out.println("5. Delete Writer");
            System.out.println("6. Exit");
            System.out.println("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> createWriter();
                case 2 -> getWriterById();
                case 3 -> getAllWriters();
                case 4 -> updateWriter();
                case 5 -> deleteWriter();
                case 6 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void getWriterById() {
        System.out.println("Enter Label id: ");
        long id = scanner.nextLong();
        Writer writer = writerController.getWriteById(id);
        System.out.println("Writer found: " + writer);
    }


    public void createWriter() {
        System.out.println("Enter firstName: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter lastName: ");
        String lastName = scanner.nextLine();
        List<Post> posts = postController.getAllPost();
        Status status = Status.ACTIVE;
        Writer newWriter = writerController.createWriter(firstName, lastName, posts, status);
        System.out.println("Writer created with ID: " + newWriter.getId());
    }

    public void getAllWriters() {
        System.out.println("All Writes: ");
        writerController.getAllWriters()
                .forEach(System.out::println);
    }

    public void updateWriter() {
        System.out.println("Enter Writer id to update: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter update firstName: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter update lastName: ");
        String lastName = scanner.nextLine();
        Status status = Status.ACTIVE;
        List<Post> posts = postController.getAllPost();
        Writer writer = writerController.updateWriter(id, firstName, lastName, posts, status);
        System.out.println("Writer updated with ID: " + writer);
    }

    public void deleteWriter() {
        System.out.println("Enter write ID to delete: ");
        long id = scanner.nextLong();
        writerController.deleteWriter(id);
        System.out.println("Writer deleted.");
    }
}

