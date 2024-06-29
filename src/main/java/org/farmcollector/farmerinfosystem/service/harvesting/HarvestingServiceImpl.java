package org.farmcollector.farmerinfosystem.service.harvesting;

import org.farmcollector.farmerinfosystem.model.Harvesting;
import org.farmcollector.farmerinfosystem.repository.HarvestingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HarvestingServiceImpl implements HarvestingService{

    private HarvestingRepository harvestingRepository;

    @Autowired
    public HarvestingServiceImpl(HarvestingRepository harvestingRepository){
        this.harvestingRepository= harvestingRepository;
    }
    @Override
    public Harvesting saveHarvestingInfo(Harvesting harvesting) {
        return harvestingRepository.save(harvesting);
    }

    @Override
    public List<Harvesting> getHarvestingInfo() {
        return List.of();
    }
}
