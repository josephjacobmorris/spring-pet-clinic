package com.example.services.map;

import com.example.model.Owner;
import com.example.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService  extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        Set<Owner> owners = super.findAll();
        return owners.stream().filter(owner -> owner.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }
}