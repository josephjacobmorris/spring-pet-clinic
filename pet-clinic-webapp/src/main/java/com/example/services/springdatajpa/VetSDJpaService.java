package com.example.services.springdatajpa;

import com.example.model.Vet;
import com.example.repositories.VetRepository;
import com.example.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public Iterable<Vet> findAll() {
        return vetRepository.findAll();
    }

    @Override
    public Vet findByLastName(String lastName) {
        return vetRepository.findByLastName(lastName).orElse(null);
    }
}
