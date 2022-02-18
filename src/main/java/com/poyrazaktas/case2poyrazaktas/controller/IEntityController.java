package com.poyrazaktas.case2poyrazaktas.controller;

import org.springframework.http.ResponseEntity;

public interface IEntityController<T> {
    public ResponseEntity findAll();
    public ResponseEntity get(Long id);
    public ResponseEntity delete(Long id);
    public ResponseEntity save(T entity);
    public ResponseEntity update(T entity);
}
