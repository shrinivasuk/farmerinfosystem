package org.farmcollector.farmerinfosystem.service.farming;

import jakarta.persistence.EntityNotFoundException;
import org.farmcollector.farmerinfosystem.model.Farm;
import org.farmcollector.farmerinfosystem.model.Harvesting;
import org.farmcollector.farmerinfosystem.model.Planting;
import org.farmcollector.farmerinfosystem.repository.FarmRepository;
import org.farmcollector.farmerinfosystem.repository.HarvestingRepository;
import org.farmcollector.farmerinfosystem.repository.PlantingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FarmServiceImpl implements FarmService {
    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private PlantingRepository plantingRepository;

    @Autowired
    private HarvestingRepository harvestingRepository;

    public void addFarm(Farm farm) {
        farmRepository.save(farm);
    }

    public void addPlanting(Planting planting) {
        plantingRepository.save(planting);
    }

    public void addHarvesting(Harvesting harvesting) {
        harvestingRepository.save(harvesting);
    }

    public List<Map<String, Object>> getReportByFarm(Long farmId, String season) {
        Farm farm = farmRepository.findById(farmId).orElseThrow(() -> new EntityNotFoundException("Farm not found"));
        List<Planting> plantings = plantingRepository.findByFarmAndSeason(farm, season);
        List<Harvesting> harvestings = harvestingRepository.findByFarmAndSeason(farm, season);

        Map<Farm, Double> expectedMap = plantings.stream()
                .collect(Collectors.groupingBy(Planting::getFarm, Collectors.summingDouble(Planting::getAmtOfExpectedProduct)));

        Map<Farm, Double> actualMap = harvestings.stream()
                .collect(Collectors.groupingBy(Harvesting::getFarm, Collectors.summingDouble(Harvesting::getAmtOfActualProduct)));

        List<Map<String, Object>> report = new ArrayList<>();
        for (Farm fieldId : expectedMap.keySet()) {
            Map<String, Object> record = new HashMap<>();
            record.put("formName", fieldId.getName());
            record.put("cropType", plantings.stream().filter(p -> p.getFarm().equals(fieldId)).findFirst().get().getCropType());
            record.put("expectedProduct", expectedMap.get(fieldId));
            record.put("actualProduct", actualMap.getOrDefault(fieldId, 0.0));
            report.add(record);
        }

        return report;
    }

    public List<Map<String, Object>> getReportByCrop(String cropType, String season) {
        List<Planting> plantings = plantingRepository.findByCropTypeAndSeason(cropType, season);
        List<Harvesting> harvestings = harvestingRepository.findByCropTypeAndSeason(cropType, season);

        Map<Farm, Double> expectedMap = plantings.stream()
                .collect(Collectors.groupingBy(Planting::getFarm, Collectors.summingDouble(Planting::getAmtOfExpectedProduct)));

        Map<Farm, Double> actualMap = harvestings.stream()
                .collect(Collectors.groupingBy(Harvesting::getFarm, Collectors.summingDouble(Harvesting::getAmtOfActualProduct)));

        List<Map<String, Object>> report = new ArrayList<>();
        for (Farm farm : expectedMap.keySet()) {
            Map<String, Object> record = new HashMap<>();
            record.put("farmId", farm.getId());
            record.put("farmName", farm.getName());
            record.put("expectedProduct", expectedMap.get(farm));
            record.put("actualProduct", actualMap.getOrDefault(farm, 0.0));
            report.add(record);
        }

        return report;
    }
}
