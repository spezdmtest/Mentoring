package com.ostapenkodmytro.javacore;

import com.ostapenkodmytro.javacore.controller.LabelController;
import com.ostapenkodmytro.javacore.repository.gson.GsonLabelRepositoryImpl;
import com.ostapenkodmytro.javacore.view.LabelView;

import java.io.FileNotFoundException;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        GsonLabelRepositoryImpl gsonLabelRepository = new GsonLabelRepositoryImpl();
        LabelController labelController = new LabelController(gsonLabelRepository);
        LabelView labelView = new LabelView(labelController);
        labelView.run();
    }
}
