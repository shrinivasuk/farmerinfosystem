package org.farmcollector.farmerinfosystem.controller;

import org.farmcollector.farmerinfosystem.exception.BadRequestException;
import org.farmcollector.farmerinfosystem.model.Harvesting;
import org.farmcollector.farmerinfosystem.service.harvesting.HarvestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Harvesting controller
 */
@RestController
@RequestMapping("/harvesting")
public class HarvestingController {

    /**
     * harvesting service
     */
    private HarvestingService harvestingService;

    /**
     * Constructor injection
     * @param harvestingService HarvestingService
     */
    @Autowired
    public HarvestingController(HarvestingService harvestingService){
        this.harvestingService = harvestingService;
    }

    /**
     * API end point to get the list of harvesting details
     *
     * @return List<Harvesting>
     */
    @GetMapping("/fetch")
    public List<Harvesting> getHarvestingInfo(){
        return harvestingService.getHarvestingInfo();
    }

    /**
     * Receices the Harvesting data in JSON format and maps to model Harvesting
     * intern it adds to the db and if success return object
     *
     * if the Amount of Actual Product less than 0 throws BadRequestException validation message
     * @param harvesting Harvesting
     * @return Harvesting Harvesting
     */
    @PostMapping("/add")
    public Harvesting addHarverstingInfo(@RequestBody Harvesting harvesting){

        if(harvesting.getAmtOfActualProduct() <=0){
            throw new BadRequestException("Harvesting actual amount should be more than 0");
        }
        return harvestingService.saveHarvestingInfo(harvesting);
    }
}
