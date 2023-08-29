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
        Writer newWriter = Writer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .posts(posts)
                .status(status)
                .build();
        return writerRepository.save(newWriter);
    }

    public Writer getWriteById(Long id) {
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters() {
        return writerRepository.getAll();
    }

    public Writer updateWriter(Long id, String firstName, String lastName, List<Post> posts, Status status) {
        Writer updateWriter = Writer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .posts(posts)
                .status(status)
                .build();
        updateWriter.setId(id);
        return writerRepository.update(updateWriter);
    }

    public void deleteWriter(Long id) {
        writerRepository.deleteById(id);
    }
}
