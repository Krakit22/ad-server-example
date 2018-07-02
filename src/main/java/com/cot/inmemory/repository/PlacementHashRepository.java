package com.cot.inmemory.repository;

import com.cot.inmemory.model.PlacementHash;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementHashRepository extends CrudRepository<PlacementHash, Long> {
}
