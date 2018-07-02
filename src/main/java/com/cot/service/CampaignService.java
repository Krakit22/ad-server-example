package com.cot.service;

import com.cot.domain.Campaign;
import com.cot.domain.Placement;

import java.util.Set;

public interface CampaignService {

    Iterable<Campaign> findAll();

    Campaign findById(Long id);

    Campaign save(Campaign campaign);

    void delete(Long id);

    Set<Campaign> findAllByPlacementsIn(Placement placement);
}
