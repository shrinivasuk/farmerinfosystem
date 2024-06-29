package org.farmcollector.farmerinfosystem;

import org.farmcollector.farmerinfosystem.model.Farm;
import org.farmcollector.farmerinfosystem.model.Harvesting;
import org.farmcollector.farmerinfosystem.model.Planting;
import org.farmcollector.farmerinfosystem.repository.FarmRepository;
import org.farmcollector.farmerinfosystem.repository.HarvestingRepository;
import org.farmcollector.farmerinfosystem.repository.PlantingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final FarmRepository farmRepository;
    private final PlantingRepository plantingRepository;
    private final HarvestingRepository harvestingRepository;

    @Autowired
    public DataInitializer(FarmRepository farmRepository, PlantingRepository plantingRepository, HarvestingRepository harvestingRepository) {
        this.farmRepository = farmRepository;
        this.plantingRepository = plantingRepository;
        this.harvestingRepository = harvestingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save some farms
        Farm farm1 = new Farm();
        farm1.setName("Green Valley");
        farm1.setLocation("North Field");
        farmRepository.save(farm1);

        Farm farm2 = new Farm();
        farm2.setName("Sunny Acres");
        farm2.setLocation("South Field");
        farmRepository.save(farm2);

        // Create and save some planting records
        Planting planting1 = new Planting();
        planting1.setFarm(farm1);
        planting1.setSeason("Spring");
        planting1.setPlantingArea(10.0);
        planting1.setCropType("Wheat");
        planting1.setAmtOfExpectedProduct(20.0);
        plantingRepository.save(planting1);

        Planting planting2 = new Planting();
        planting2.setFarm(farm2);
        planting2.setSeason("Spring");
        planting2.setPlantingArea(15.0);
        planting2.setCropType("Corn");
        planting2.setAmtOfExpectedProduct(30.0);
        plantingRepository.save(planting2);

        // Create and save some harvesting records
        Harvesting harvesting1 = new Harvesting();
        harvesting1.setFarm(farm1);
        harvesting1.setSeason("Spring");
        harvesting1.setCropType("Wheat");
        harvesting1.setAmtOfActualProduct(18.0);
        harvestingRepository.save(harvesting1);

        Harvesting harvesting2 = new Harvesting();
        harvesting2.setFarm(farm2);
        harvesting2.setSeason("Spring");
        harvesting2.setCropType("Corn");
        harvesting2.setAmtOfActualProduct(28.0);
        harvestingRepository.save(harvesting2);
    }
}
