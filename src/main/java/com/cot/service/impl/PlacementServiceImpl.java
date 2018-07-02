package com.cot.service.impl;

import com.cot.domain.Placement;
import com.cot.exception.EntityNotFoundException;
import com.cot.repository.PlacementRepository;
import com.cot.service.PlacementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlacementServiceImpl implements PlacementService {

    private final PlacementRepository placementRepository;

    @Override
    public Iterable<Placement> findAll() {
        return placementRepository.findAll();
    }

    @Override
    public Placement findById(Long id) {
        return placementRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException(Placement.class, id));
    }

    @Override
    public Placement save(Placement placement) {
        return placementRepository.save(placement);
    }

    @Override
    public void delete(Long id) {
        placementRepository.delete(findById(id));
    }
}
