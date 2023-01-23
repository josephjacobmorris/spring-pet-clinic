package com.example.services;

public interface PersonService<T,ID> extends CrudService<T,ID> {
    T findByLastName(String lastName);
}
