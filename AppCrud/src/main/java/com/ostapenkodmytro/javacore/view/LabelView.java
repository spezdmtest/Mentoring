package com.ostapenkodmytro.javacore.view;

import com.ostapenkodmytro.javacore.controller.LabelController;
import com.ostapenkodmytro.javacore.enums.Status;
import com.ostapenkodmytro.javacore.model.Label;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class LabelView {

    private final LabelController labelController;
    private final Scanner scanner;

    public LabelView(LabelController labelController) {
        this.labelController = labelController;
        this.scanner = new Scanner(System.in);
    }


    public void run()  {
        boolean running = true;

        while (running) {
            System.out.println("1. Create Label");
            System.out.println("2. Get label by ID.");
            System.out.println("3. Get All Labels.");
            System.out.println("4. Update Label");
            System.out.println("5. Delete label");
            System.out.println("6. Exit");
            System.out.println("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> createLabel();
                case 2 -> getLabelById();
                case 3 -> getAllLabels();
                case 4 -> updateLabel();
                case 5 -> deleteLabel();
                case 6 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void getLabelById() {
        System.out.println("Enter Label id: ");
        long id = scanner.nextLong();
        Label label = labelController.getLabelById(id);
        System.out.println("Label found: " + label);
    }


    public void createLabel() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        Status status = Status.ACTIVE;
        Label newLabel = labelController.createLabel(name, status);
        System.out.println("Label created with ID: " + newLabel.getId());
    }

    public void getAllLabels() {
        System.out.println("All Labels: ");
        labelController.getALLLabels()
                .forEach(System.out::println);
    }

    public void updateLabel() {
        System.out.println("Enter Label id to update: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter update name: ");
        String name = scanner.nextLine();
        Status status = Status.ACTIVE;
        Label updatedLabel = labelController.updateLabel(id, name, status);
        System.out.println("Label updated wit ID: " + updatedLabel);
    }

    public void deleteLabel() {
        System.out.println("Enter label ID to delete: ");
        long id = scanner.nextLong();
        labelController.deleteLabel(id);
        System.out.println("Label deleted.");
    }
}

