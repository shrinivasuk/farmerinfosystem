package org.farmcollector.farmerinfosystem.repository;

import org.farmcollector.farmerinfosystem.model.Harvesting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestingRepository extends JpaRepository<Harvesting,Long> {
}
