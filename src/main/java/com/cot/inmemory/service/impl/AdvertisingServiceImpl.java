package com.cot.inmemory.service.impl;

import com.cot.exception.PlacementNotContainCampaignException;
import com.cot.inmemory.model.CampaignHash;
import com.cot.inmemory.model.PlacementHash;
import com.cot.inmemory.service.AdvertisingService;
import com.cot.inmemory.service.PlacementHashService;
import com.google.common.annotations.VisibleForTesting;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdvertisingServiceImpl implements AdvertisingService {

    private final PlacementHashService placementHashService;

    @Override
    public String getAdvertisingPhrase(Long placementId) {
        PlacementHash placementHash = placementHashService.findById(placementId);
        return chooseOnWeight(placementHash.getCampaigns())
                .orElseThrow(() -> new PlacementNotContainCampaignException(placementId)).getAdvertisingPhrase();
    }

    @VisibleForTesting
    protected Optional<CampaignHash> chooseOnWeight(Set<CampaignHash> campaignHashes) {
        if (Objects.nonNull(campaignHashes) && !campaignHashes.isEmpty()) {
            long completeWeight = campaignHashes.stream().collect(Collectors.summarizingInt(CampaignHash::getWeight)).getSum();
            double r = Math.random() * completeWeight;
            double countWeight = 0.0;
            for (CampaignHash campaignHash : campaignHashes) {
                countWeight += campaignHash.getWeight();
                if (countWeight >= r)
                    return Optional.of(campaignHash);
            }
        }
        return Optional.empty();
    }
}
