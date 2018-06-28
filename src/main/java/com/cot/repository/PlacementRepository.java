package com.cot.repository;

import com.cot.domain.Placement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "placement", path = "placement")
public interface PlacementRepository extends CrudRepository<Placement, Long> {
}
