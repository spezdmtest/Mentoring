package com.ostapenkodmytro.javacore.controller;

import com.ostapenkodmytro.javacore.enums.Status;
import com.ostapenkodmytro.javacore.model.Post;
import com.ostapenkodmytro.javacore.model.Writer;
import com.ostapenkodmytro.javacore.repository.WriterRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class WriterController {

    private final WriterRepository writerRepository;

    public Writer createWriter(String firstName, String lastName, List<Post> posts, Status status) {
        Writer newWriter = new Writer(firstName, lastName, posts, status);
        return writerRepository.save(newWriter);
    }

    public Writer getWriteById(Long id) {
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters() {
        return writerRepository.getAll();
    }

    public Writer updateWriter(Long id, String firstName, String lastName, List<Post> posts, Status status) {
        Writer updateWriter = new Writer(firstName, lastName, posts, status);
        updateWriter.setId(id);
        return writerRepository.update(updateWriter);
    }

    public void deleteWriter(Long id) {
        writerRepository.deleteById(id);
    }
}
