package com.cot.service.impl;

import com.cot.domain.Campaign;
import com.cot.domain.Placement;
import com.cot.exception.EntityNotFoundException;
import com.cot.repository.CampaignRepository;
import com.cot.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    @Override
    public Iterable<Campaign> findAll() {
        return campaignRepository.findAll();
    }

    @Override
    public Campaign findById(Long id) {
        return campaignRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException(Campaign.class, id));
    }

    @Override
    public Campaign save(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @Override
    public void delete(Long id) {
        campaignRepository.delete(findById(id));
    }

    @Override
    public Set<Campaign> findAllByPlacementsIn(Placement placement) {
        return campaignRepository.findAllByPlacementsIn(placement);
    }
}
