package com.cot.service;

import com.cot.domain.Campaign;

public interface CampaignService {

    Iterable<Campaign> findAll();

    Campaign findById(Long id);

    Campaign save(Campaign campaign);

    void delete(Long id);
}
