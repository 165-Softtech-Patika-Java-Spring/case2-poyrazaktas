package com.poyrazaktas.case2poyrazaktas.service.entityservice;

import java.util.List;
import java.util.Optional;

public interface IEntityService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    boolean existsById(Long id);

    T get(Long id);

    T save(T entity);

    void delete(T entity);
}
