package com.example.services;

import com.example.model.Person;
import com.example.model.Vet;


public interface VetService<V extends Person, L extends Number> extends PersonService<Vet,Long> {
}
