package com.cot.repository;

import com.cot.domain.Placement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepository extends CrudRepository<Placement, Long> {
}
