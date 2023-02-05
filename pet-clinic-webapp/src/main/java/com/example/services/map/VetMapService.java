package com.example.services.map;

import com.example.model.Vet;
import com.example.services.SpecialityService;
import com.example.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"map", "default"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Vet save(Vet object) {
        if (object == null) {
            return null;
        }
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    specialityService.save(speciality);
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findByLastName(String lastName) {
        Set<Vet> vets = super.findAll();
        return vets.stream().filter(vet -> vet.getLastName().equals(lastName)).findFirst().orElse(null);
    }
}
