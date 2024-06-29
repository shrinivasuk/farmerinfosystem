package org.farmcollector.farmerinfosystem.repository;

import org.farmcollector.farmerinfosystem.model.Planting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantingRepository extends JpaRepository<Planting,Long> {
}
