package com.ostapenkodmytro.javacore;

import com.ostapenkodmytro.javacore.controller.LabelController;
import com.ostapenkodmytro.javacore.controller.PostController;
import com.ostapenkodmytro.javacore.controller.WriterController;
import com.ostapenkodmytro.javacore.repository.gson.GsonLabelRepositoryImpl;
import com.ostapenkodmytro.javacore.repository.gson.GsonPostRepositoryImpl;
import com.ostapenkodmytro.javacore.repository.gson.GsonWriterRepositoryImpl;
import com.ostapenkodmytro.javacore.view.LabelView;
import com.ostapenkodmytro.javacore.view.PostView;
import com.ostapenkodmytro.javacore.view.WriterView;

import java.util.Scanner;

public class ApplicationContext {
    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Select an option:");
        System.out.println("1. Label");
        System.out.println("2. Post");
        System.out.println("3. Write");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                labelRun();
                break;
            case 2:
                postRun();
            case 3:
                writerRun();
            default:
                System.out.println("Invalid choice");
        }
    }
    public void labelRun() {
        GsonLabelRepositoryImpl gsonLabelRepository = new GsonLabelRepositoryImpl();
        LabelController labelController = new LabelController(gsonLabelRepository);
        LabelView labelView = new LabelView(labelController);
        labelView.run();
    }

    private void postRun() {
        GsonLabelRepositoryImpl gsonLabelRepository = new GsonLabelRepositoryImpl();
        GsonPostRepositoryImpl gsonPostRepository = new GsonPostRepositoryImpl();
        LabelController labelController = new LabelController(gsonLabelRepository);
        PostController postController = new PostController(gsonPostRepository);
        PostView postView = new PostView(postController, labelController);
        postView.run();
    }


    public void writerRun() {
        GsonPostRepositoryImpl gsonPostRepository = new GsonPostRepositoryImpl();
        GsonWriterRepositoryImpl gsonWriterRepository = new GsonWriterRepositoryImpl();
        PostController postController = new PostController(gsonPostRepository);
        WriterController writerController = new WriterController(gsonWriterRepository);
        WriterView writerView = new WriterView(postController, writerController);
        writerView.run();
    }
}