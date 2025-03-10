package org.farmcollector.farmerinfosystem.repository;

import org.farmcollector.farmerinfosystem.model.Farm;
import org.farmcollector.farmerinfosystem.model.Planting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantingRepository extends JpaRepository<Planting,Long> {
    List<Planting> findByFarmAndSeason(Farm farm, String season);
    List<Planting> findByCropTypeAndSeason(String cropType, String season);
}
