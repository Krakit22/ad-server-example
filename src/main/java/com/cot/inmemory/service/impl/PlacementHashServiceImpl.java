package com.cot.inmemory.service.impl;

import com.cot.exception.EntityNotFoundException;
import com.cot.inmemory.model.PlacementHash;
import com.cot.inmemory.repository.PlacementHashRepository;
import com.cot.inmemory.service.PlacementHashService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlacementHashServiceImpl implements PlacementHashService {

    private final PlacementHashRepository placementHashRepository;

    public void deleteAll() {
        placementHashRepository.deleteAll();
    }

    @Override
    public PlacementHash findById(Long id) {
        return placementHashRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException(PlacementHash.class, id));
    }

    @Override
    public PlacementHash save(PlacementHash placementHash) {
        return placementHashRepository.save(placementHash);
    }
}
