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
        placementHashService.save(PlacementHash.builder().id(999L).name("placement_test").build());
        PlacementHash placementHash = placementHashService.findById(999L);

        assertNotNull(placementHash);
        assertEquals(placementHash.getName(), "placement_test");
    }
}
