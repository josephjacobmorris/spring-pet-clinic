package com.example.services.map;

import com.example.model.Pet;
import com.example.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService<Pet, Long> {
    @Override
    public Pet save(Pet object) {
        return super.save( object);
    }
}
