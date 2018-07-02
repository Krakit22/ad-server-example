package com.cot.service;

import com.cot.base.AbstractIntegrationTest;
import com.cot.domain.Placement;
import com.cot.exception.EntityNotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PlacementServiceTest extends AbstractIntegrationTest {

    @Autowired
    private PlacementService placementService;

    @Test
    public void testFindById() {
        Placement placement = placementService.findById(1L);

        assertNotNull(placement);
        assertEquals(placement.getName(), "placement_test");
    }

    @Test
    public void testFindAll() {
        Iterable<Placement> placements = placementService.findAll();
        assertNotNull(placements);
    }

    @Test
    public void testSave() {
        Placement placement = placementService.save(Placement.builder().name("save_test").build());
        assertNotNull(placement);
        assertNotNull(placement.getId());
    }

    @Test(expected = EntityNotFoundException.class)
    public void testDelete() {
        placementService.delete(1L);
        Placement placement = placementService.findById(1L);
        assertNull(placement);
    }
}
