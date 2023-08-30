package com.ostapenkodmytro.javacore.repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ostapenkodmytro.javacore.enums.Status;
import com.ostapenkodmytro.javacore.exception.NotFoundException;
import com.ostapenkodmytro.javacore.model.Writer;
import com.ostapenkodmytro.javacore.repository.WriterRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private final String FILE_PATH = "C:/Users/spezdm/IdeaProjects/Mentoring/AppCrud/src/main/resources/writers.json";

    private static final Gson gson = new Gson();

    @Override
    public Writer getById(Long id) {
        return loadWrites().stream()
                .filter(post -> post.getId().equals(id))
                .findFirst().orElseThrow(() -> new NotFoundException("Writer not found with id: " + id));
    }

    @Override
    public List<Writer> getAll() {
        return loadWrites();
    }

    @Override
    public Writer save(Writer writer) {
        List<Writer> currentWriters = loadWrites();
        long nextId = IdGenerated.generatedNextId(currentWriters, Writer::getId);
        writer.setId(nextId);
        currentWriters.add(writer);
        saveWrites(currentWriters);
        return writer;
    }

    @Override
    public Writer update(Writer updateWriter) {
        List<Writer> currentWriters = loadWrites();
        List<Writer> writers = updatedWrites(currentWriters, updateWriter);
        saveWrites(writers);
        return updateWriter;
    }

    @Override
    public void deleteById(Long id) {
        List<Writer> currentWrites = loadWrites();
        Writer writer = currentWrites.stream()
                .filter(existingWrite ->
                        existingWrite.getId().equals(id))
                .findFirst().orElseThrow(() -> new NotFoundException("Writer not found with id: " + id));
        writer.setStatus(Status.DELETED);
        saveWrites(currentWrites);
    }

    private List<Writer> loadWrites() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Writer>>() {
            }.getType();
            List<Writer> writes = gson.fromJson(reader, type);
            if (writes == null) {
                writes = new ArrayList<>();
            }
            return writes;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private void saveWrites(List<Writer> writes) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(writes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Writer> updatedWrites(List<Writer> currentWriters, Writer updateWriter) {
        return currentWriters.stream()
                .map(existingWrite -> {
                    if (existingWrite.getId().equals(updateWriter.getId())) {
                        return updateWriter;
                    }
                    return existingWrite;
                }).toList();
    }
}
