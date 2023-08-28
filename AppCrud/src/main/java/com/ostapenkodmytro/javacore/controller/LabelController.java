package com.ostapenkodmytro.javacore.controller;


import com.ostapenkodmytro.javacore.enums.Status;
import com.ostapenkodmytro.javacore.model.Label;
import com.ostapenkodmytro.javacore.repository.LabelRepository;
import lombok.RequiredArgsConstructor;

import java.io.FileNotFoundException;
import java.util.List;

@RequiredArgsConstructor
public class LabelController {

    private final LabelRepository labelRepository;

    public Label createLabel(String name, Status status) {
        var newLabel = new Label(name, status);
        return labelRepository.save(newLabel);
    }

    public Label getLabelById(Long id) throws FileNotFoundException {
        return labelRepository.getById(id);
    }

    public List<Label> getALLLabels() {
        return labelRepository.getAll();
    }

    public Label updateLabel(Long id, String name, Status status) {
        Label updateLabel = new Label(name, status);
        updateLabel.setId(id);
        return labelRepository.update(updateLabel);
    }

    public void deleteLabel(Long id) throws FileNotFoundException {
        labelRepository.deleteById(id);
    }
}
