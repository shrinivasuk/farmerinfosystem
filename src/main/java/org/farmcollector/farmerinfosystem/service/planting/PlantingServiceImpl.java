package org.farmcollector.farmerinfosystem.service.planting;

import lombok.NoArgsConstructor;
import org.farmcollector.farmerinfosystem.model.Planting;
import org.farmcollector.farmerinfosystem.repository.PlantingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class PlantingServiceImpl implements PlantingService {

    private PlantingRepository plantingRepository;

    @Autowired
    public PlantingServiceImpl(PlantingRepository plantingRepository){
        this.plantingRepository = plantingRepository;
    }

    @Override
    public List<Planting> getPlantingInfo() {
        return plantingRepository.findAll();
    }

    @Override
    public Planting savePlantingInfo(Planting planting) {
        return plantingRepository.save(planting);
    }
}
