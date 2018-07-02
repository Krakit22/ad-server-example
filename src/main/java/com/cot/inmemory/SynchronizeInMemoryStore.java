package com.cot.inmemory;

import com.cot.inmemory.model.PlacementHash;
import com.cot.inmemory.service.PlacementHashService;
import com.cot.service.CampaignService;
import com.cot.service.PlacementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class SynchronizeInMemoryStore {

    private final CampaignService campaignService;
    private final PlacementService placementService;
    private final PlacementHashService placementHashService;

    @Scheduled(fixedDelayString = "${adserver.synchronize-delay}")
    public void synchronizedInMemoryStore() {
        log.info("Load data from persistent storage to in memory hash");
        placementHashService.deleteAll();
        placementService.findAll()
                .forEach(placement -> placementHashService
                        .save(new PlacementHash(placement, campaignService.findAllByPlacementsIn(placement))));
    }
}
