package org.farmcollector.farmerinfosystem.repository;

import org.farmcollector.farmerinfosystem.model.Farm;
import org.farmcollector.farmerinfosystem.model.Harvesting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HarvestingRepository extends JpaRepository<Harvesting,Long> {

    List<Harvesting> findByFarmAndSeason(Farm farm, String season);
    List<Harvesting> findByCropTypeAndSeason(String cropType, String season);
}
