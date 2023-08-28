package com.ostapenkodmytro.javacore.repository;

import java.io.FileNotFoundException;
import java.util.List;

public interface GenericRepository<T, ID> {
    T getById(ID id) throws FileNotFoundException;

    List<T> getAll();

    T save(T t);

    T update(T t);

    void deleteById(ID id) throws FileNotFoundException;
}
