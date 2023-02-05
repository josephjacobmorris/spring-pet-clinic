package com.example.services.map;

import com.example.model.Pet;
import com.example.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map", "default"})
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Pet save(Pet object) {
        return super.save( object);
    }
}
