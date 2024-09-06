package com.dio.space.service;

import java.util.List;
import java.util.Optional;

public interface CrudService <ID, T> {
    List<T> findAll();
    T findById(ID id);
    T create(T entity);
    T  update(ID id, T entity);
    void delete(ID id);

}
