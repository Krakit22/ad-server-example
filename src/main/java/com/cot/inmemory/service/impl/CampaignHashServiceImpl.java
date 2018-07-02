package com.cot.inmemory.service.impl;

import com.cot.exception.EntityNotFoundException;
import com.cot.inmemory.model.CampaignHash;
import com.cot.inmemory.repository.CampaignHashRepository;
import com.cot.inmemory.service.CampaignHashService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CampaignHashServiceImpl implements CampaignHashService {

    public final CampaignHashRepository campaignHashRepository;

    @Override
    public CampaignHash save(CampaignHash campaignHash) {
        return campaignHashRepository.save(campaignHash);
    }

    @Override
    public CampaignHash findById(Long id) {
        return campaignHashRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException(CampaignHash.class, id));
    }
}
