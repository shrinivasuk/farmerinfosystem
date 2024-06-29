package org.farmcollector.farmerinfosystem.service.farming;

import org.farmcollector.farmerinfosystem.model.Farm;
import org.farmcollector.farmerinfosystem.repository.FarmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Test case for adding form details
 */
class FarmServiceImplTest {
    @Mock
    private FarmRepository farmRepository;

    @InjectMocks
    private FarmServiceImpl farmService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddFarm() {
        Farm farm = new Farm();
        farm.setName("Test Farm");
        farm.setLocation("Test Location");

        farmService.addFarm(farm);

        verify(farmRepository, times(1)).save(farm);
    }
}