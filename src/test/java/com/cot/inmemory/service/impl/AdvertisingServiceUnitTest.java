package com.cot.inmemory.service.impl;

import com.cot.inmemory.model.CampaignHash;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AdvertisingServiceUnitTest {

    @Test
    public void test() {
        AdvertisingServiceImpl advertisingService = new AdvertisingServiceImpl(null);

        CampaignHash campaignHash1 = CampaignHash.builder().name("test1").weight(10).build();
        CampaignHash campaignHash2 = CampaignHash.builder().name("test2").weight(30).build();
        Set<CampaignHash> campaignHashSet = new HashSet<>();
        campaignHashSet.add(campaignHash1);
        campaignHashSet.add(campaignHash2);

        int countFirstCampaign = 0;
        for (int i = 0; i < 100000; i++) {
            if (advertisingService.chooseOnWeight(campaignHashSet).get().getName().equals("test1")) {
                countFirstCampaign++;
            }
        }
        Assert.assertTrue(countFirstCampaign > 24000);
        Assert.assertTrue(countFirstCampaign < 26000);
    }
}
