package com.example.services;

public interface CrudService <T,ID>{
    T findById(ID id);

    T save(T object);

    Iterable<T> findAll();
}
