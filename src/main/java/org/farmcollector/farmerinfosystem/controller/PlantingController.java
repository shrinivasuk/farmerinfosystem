package org.farmcollector.farmerinfosystem.controller;

import org.farmcollector.farmerinfosystem.exception.BadRequestException;
import org.farmcollector.farmerinfosystem.model.Planting;
import org.farmcollector.farmerinfosystem.service.planting.PlantingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planting")
public class PlantingController {

    @Autowired
    private PlantingService plantingService;

    @GetMapping("/fetch")
    public List<Planting> getPlantingInfo(){
        return plantingService.getPlantingInfo();
    }

    @PostMapping("/add")
    public Planting addPlantingInfo(@RequestBody Planting planting){

        if(planting.getPlantingArea() <=0){
            throw new BadRequestException("Planting area must be greater than 0");
        }
        return plantingService.savePlantingInfo(planting);
    }



}
