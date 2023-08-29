package com.ostapenkodmytro.javacore.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ostapenkodmytro.javacore.enums.Status;
import com.ostapenkodmytro.javacore.exception.NotFoundException;
import com.ostapenkodmytro.javacore.model.Label;
import com.ostapenkodmytro.javacore.repository.LabelRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {

    private final String FILE_PATH = "C:/Users/spezdm/IdeaProjects/Mentoring/AppCrud/src/main/resources/labels.json";

    private final Gson gson = new Gson();

    @Override
    public Label getById(Long id) {
        return loadLabels().stream()
                .filter(label -> label.getId().equals(id))
                .findFirst().orElseThrow(() -> new NotFoundException("Label not found with id: " + id));
    }

    @Override
    public List<Label> getAll() {
        return loadLabels();
    }

    @Override
    public Label save(Label label) {
        List<Label> currentLabels = loadLabels();
        long nextId = currentLabels.stream()
                .mapToLong(Label::getId)
                .max().orElse(0) + 1;
        label.setId(nextId);
        currentLabels.add(label);
        saveLabels(currentLabels);
        return label;
    }

    @Override
    public Label update(Label updateLabel) {
        List<Label> currentLabels = loadLabels();
        List<Label> labels = updatedLabels(currentLabels, updateLabel);
        saveLabels(labels);
        return updateLabel;
    }

    @Override
    public void deleteById(Long id) {
        List<Label> currentLabels = loadLabels();
        Label label = currentLabels.stream()
                .filter(existingLabel ->
                        existingLabel.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Label not found with id: " + id));
        label.setStatus(Status.DELETED);
        saveLabels(currentLabels);
    }

    private List<Label> loadLabels() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Label>>() {
            }.getType();
            List<Label> labels = gson.fromJson(reader, type);
            if (labels == null) {
                labels = new ArrayList<>();
            }
            return labels;

        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void saveLabels(List<Label> labels) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(labels, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Label> updatedLabels(List<Label> currentLabels, Label updateLabel) {
        return currentLabels.stream()
                .map(existingLabel -> {
                    if (existingLabel.getId().equals(updateLabel.getId())) {
                        return updateLabel;
                    }
                    return existingLabel;
                }).toList();
    }
}
