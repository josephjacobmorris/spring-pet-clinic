package com.example.services.map;

import com.example.model.Vet;
import com.example.services.VetService;

import java.util.Set;

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService<Vet, Long> {
    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findByLastName(String lastName) {
        Set<Vet> vets = super.findAll();
        return vets.stream().filter(vet -> vet.getLastName().equals(lastName)).findFirst().orElse(null);
    }
}
