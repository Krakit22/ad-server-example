package com.cot.repository;

import com.cot.domain.Campaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "campaign", path = "campaign")
public interface CampaignRepository extends CrudRepository<Campaign, Long> {
}
