package com.cot.service;

import com.cot.base.AbstractIntegrationTest;
import com.cot.inmemory.model.CampaignHash;
import com.cot.inmemory.service.CampaignHashService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CampaignHashServiceTest extends AbstractIntegrationTest {

    @Autowired
    private CampaignHashService campaignHashService;

    @Test
    public void testFindById() {
        CampaignHash campaignHash = campaignHashService.findById(1L);

        assertNotNull(campaignHash);
        assertEquals(campaignHash.getName(), "campaign_test");
    }
}
