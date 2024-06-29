package org.farmcollector.farmerinfosystem.service.planting;


import org.farmcollector.farmerinfosystem.model.Planting;

import java.util.List;

public interface PlantingService {

    public List<Planting> getPlantingInfo();

    public Planting savePlantingInfo(Planting planting);
}
