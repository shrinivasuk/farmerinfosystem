package org.farmcollector.farmerinfosystem.controller;

import org.farmcollector.farmerinfosystem.model.Farm;
import org.farmcollector.farmerinfosystem.model.Planting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.farmcollector.farmerinfosystem.exception.BadRequestException;
import org.farmcollector.farmerinfosystem.model.Harvesting;
import org.farmcollector.farmerinfosystem.service.harvesting.HarvestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.farmcollector.farmerinfosystem.service.farming.FarmService;

import java.util.List;
import java.util.Map;

@RestController
public class FarmController {

    @Autowired
    private FarmService farmService;

    @PostMapping("/farms")
    public ResponseEntity<String> addFarm(@RequestBody Farm farm) {
        if(farm.getName().isBlank()){
            throw new BadRequestException("Farm name can not be blank");
        }
        farmService.addFarm(farm);
        return ResponseEntity.ok("Farm added successfully");
    }

    @PostMapping("/planted")
    public ResponseEntity<String> addPlanting(@RequestBody Planting planting) {
        if(planting.getPlantingArea() <=0){
            throw new BadRequestException("Planting area must be greater than 0");
        }
        farmService.addPlanting(planting);
        return ResponseEntity.ok("Planting record added successfully");
    }

    @PostMapping("/harvested")
    public ResponseEntity<String> addHarvesting(@RequestBody Harvesting harvesting) {
        if(harvesting.getAmtOfActualProduct() <=0){
            throw new BadRequestException("Harvesting actual amount should be more than 0");
        }
        farmService.addHarvesting(harvesting);
        return ResponseEntity.ok("Harvesting record added successfully");
    }

    @GetMapping("/reports/farm")
    public ResponseEntity<List<Map<String, Object>>> getReportByFarm(@RequestParam Long farmId, @RequestParam String season) {
        List<Map<String, Object>> report = farmService.getReportByFarm(farmId, season);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/reports/crop")
    public ResponseEntity<List<Map<String, Object>>> getReportByCrop(@RequestParam String cropType, @RequestParam String season) {
        List<Map<String, Object>> report = farmService.getReportByCrop(cropType, season);
        return ResponseEntity.ok(report);
    }
}
