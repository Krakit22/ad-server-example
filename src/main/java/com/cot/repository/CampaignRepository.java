package com.cot.repository;

import com.cot.domain.Campaign;
import com.cot.domain.Placement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Long> {

    @Query("select c from Campaign c left join c.placements p where p.id = placementId")
    Set<Campaign> findAllByPlacementId(Long placementId);

    Set<Campaign> findAllByPlacementsIn(Placement placement);
}
