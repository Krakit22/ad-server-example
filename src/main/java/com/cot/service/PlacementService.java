package com.cot.service;

import com.cot.domain.Placement;

public interface PlacementService {

    Iterable<Placement> findAll();

    Placement findById(Long id);

    Placement save(Placement placement);

    void delete(Long id);
}
