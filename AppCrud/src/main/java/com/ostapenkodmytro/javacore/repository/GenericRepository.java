package com.ostapenkodmytro.javacore.repository;

import com.ostapenkodmytro.javacore.model.Post;

import java.util.List;

public interface GenericRepository<T, ID> {
    T getById(ID id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void deleteById(ID id);
}
