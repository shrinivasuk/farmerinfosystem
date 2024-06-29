package org.farmcollector.farmerinfosystem.repository;

import org.farmcollector.farmerinfosystem.model.Farm;
import org.farmcollector.farmerinfosystem.model.Harvesting;
import org.farmcollector.farmerinfosystem.model.Planting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Farm Repository
 */
public interface FarmRepository extends JpaRepository<Farm, Long> {



}
