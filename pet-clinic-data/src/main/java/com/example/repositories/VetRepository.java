package com.example.repositories;

import com.example.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VetRepository extends CrudRepository<Vet,Long> {
    public Optional<Vet> findByLastName(String lastName);
}
