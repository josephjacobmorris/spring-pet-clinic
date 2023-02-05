package com.example.services.map;

import com.example.model.PetType;
import com.example.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"map", "default"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
