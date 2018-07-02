package com.cot.inmemory.service;

import com.cot.inmemory.model.PlacementHash;

public interface PlacementHashService {

    void deleteAll();

    PlacementHash findById(Long id);

    PlacementHash save(PlacementHash placementHash);
}
