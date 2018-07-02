package com.cot.service.impl;

import com.cot.base.AbstractIntegrationTest;
import com.cot.inmemory.model.PlacementHash;
import com.cot.inmemory.service.PlacementHashService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlacementHashServiceTest extends AbstractIntegrationTest {

    @Autowired
    private PlacementHashService placementHashService;

    @Test
    public void testFindById() {
        PlacementHash placementHash = placementHashService.findById(1L);

        assertNotNull(placementHash);
        assertEquals(placementHash.getName(), "placement_test");
    }
}
