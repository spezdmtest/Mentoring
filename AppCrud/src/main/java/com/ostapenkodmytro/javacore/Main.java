package com.ostapenkodmytro.javacore;

import com.ostapenkodmytro.javacore.controller.PostController;
import com.ostapenkodmytro.javacore.controller.WriterController;
import com.ostapenkodmytro.javacore.repository.gson.GsonPostRepositoryImpl;
import com.ostapenkodmytro.javacore.repository.gson.GsonWriterRepositoryImpl;
import com.ostapenkodmytro.javacore.view.WriterView;

/**
 * Crud API!
 */
public class Main {
    public static void main(String[] args) {

//        GsonLabelRepositoryImpl gsonLabelRepository = new GsonLabelRepositoryImpl();
//        LabelController labelController = new LabelController(gsonLabelRepository);
//        LabelView labelView = new LabelView(labelController);
//        labelView.run();

//        GsonLabelRepositoryImpl gsonLabelRepository = new GsonLabelRepositoryImpl();
//        GsonPostRepositoryImpl gsonPostRepository = new GsonPostRepositoryImpl();
//        LabelController labelController = new LabelController(gsonLabelRepository);
//        PostController postController = new PostController(gsonPostRepository);
//        PostView postView = new PostView(postController,labelController);
//        postView.run();
//
        GsonPostRepositoryImpl gsonPostRepository = new GsonPostRepositoryImpl();
        GsonWriterRepositoryImpl gsonWriterRepository = new GsonWriterRepositoryImpl();
        PostController postController = new PostController(gsonPostRepository);
        WriterController writerController = new WriterController(gsonWriterRepository);
        WriterView writerView = new WriterView(postController, writerController);
        writerView.run();
    }
}
