package com.cot.service.impl;

import com.cot.base.AbstractIntegrationTest;
import com.cot.domain.Campaign;
import com.cot.exception.EntityNotFoundException;
import com.cot.service.CampaignService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CampaignServiceTest extends AbstractIntegrationTest {

    @Autowired
    private CampaignService campaignService;

    @Test
    public void testFindById() {
        Campaign campaign = campaignService.findById(1L);

        assertNotNull(campaign);
        assertEquals(campaign.getName(), "campaign_test");
        assertNotNull(campaign.getPlacements());
        assertTrue(!campaign.getPlacements().isEmpty());
    }

    @Test
    public void testFindAll() {
        Iterable<Campaign> campaigns = campaignService.findAll();
        assertNotNull(campaigns);
    }

    @Test
    public void testSave() {
        Campaign campaign = campaignService.save(Campaign.builder().name("save_test").build());
        assertNotNull(campaign);
        assertNotNull(campaign.getId());
    }

    @Test(expected = EntityNotFoundException.class)
    public void testDelete() {
        campaignService.delete(3L);
        Campaign campaign = campaignService.findById(3L);
        assertNull(campaign);
    }
}
