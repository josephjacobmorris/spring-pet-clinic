package com.example.services.map;

import com.example.model.PetType;
import com.example.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
