package org.farmcollector.farmerinfosystem.service.harvesting;

import org.farmcollector.farmerinfosystem.model.Harvesting;

import java.util.List;


public interface HarvestingService {
    Harvesting saveHarvestingInfo(Harvesting harvesting);

    List<Harvesting> getHarvestingInfo();
}
