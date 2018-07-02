package com.cot.inmemory.service;

import com.cot.inmemory.model.CampaignHash;

public interface CampaignHashService {

    CampaignHash save(CampaignHash campaignHash);

    CampaignHash findById(Long id);
}
