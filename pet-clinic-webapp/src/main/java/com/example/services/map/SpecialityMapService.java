package com.example.services.map;

import com.example.model.Speciality;
import com.example.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality,Long> implements SpecialityService {
}
