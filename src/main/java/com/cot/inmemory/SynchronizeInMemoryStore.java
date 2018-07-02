package com.cot.inmemory;

import com.cot.inmemory.model.CampaignHash;
import com.cot.inmemory.service.CampaignHashService;
import com.cot.service.CampaignService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class SynchronizeInMemoryStore {

    private final CampaignService campaignService;
    private final CampaignHashService campaignHashService;

    @Scheduled(fixedDelayString = "${adserver.synchronize-delay}")
    public void synchronizedInMemoryStore() {
        log.info("Load data from persistent storage to in memory hash");
        campaignService.findAll().forEach(campaign -> campaignHashService.save(new CampaignHash(campaign)));
    }
}
