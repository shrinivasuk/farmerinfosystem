package org.farmcollector.farmerinfosystem.service.farming;

import org.farmcollector.farmerinfosystem.model.Farm;
import org.farmcollector.farmerinfosystem.model.Harvesting;
import org.farmcollector.farmerinfosystem.model.Planting;

import java.util.List;
import java.util.Map;

public interface FarmService {
    public void addPlanting(Planting planting);
    public void addHarvesting(Harvesting harvesting);
    public void addFarm(Farm farm);

    public List<Map<String, Object>> getReportByFarm(Long farmId, String season);
    public List<Map<String, Object>> getReportByCrop(String cropType, String season);
}
