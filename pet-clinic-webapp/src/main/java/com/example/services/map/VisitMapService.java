package com.example.services.map;

import com.example.model.Visit;
import com.example.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getId() == null) {
            throw new RuntimeException("Pet or Pet Id cannot be null in pet visit");
        } else if (visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("owner or owner Id cannot be null in pet in pet visit");
        }
        return super.save(visit);
    }
}
