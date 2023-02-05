package com.example.services.map;

import com.example.model.Owner;
import com.example.services.OwnerService;
import com.example.services.PetService;
import com.example.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"map", "default"})
public class OwnerMapService  extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        Set<Owner> owners = super.findAll();
        return owners.stream().filter(owner -> owner.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        if (object == null) {
            return null;
        }
        if (object.getPets().size() > 0) {
            object.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    petTypeService.save(pet.getPetType());
                } else {
                    throw new IllegalArgumentException("PetType should not be null");
                }
                petService.save(pet);
            });
        }
        return super.save(object);
    }
}