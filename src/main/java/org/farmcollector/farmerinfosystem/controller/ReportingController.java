package org.farmcollector.farmerinfosystem.controller;

import org.farmcollector.farmerinfosystem.service.reporting.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Reporting Controller responsible for fetching data for reports
 */
@RestController()
@RequestMapping("/reports")
public class ReportingController {

    private ReportingService reportingService;

    @Autowired
    public ReportingController(ReportingService reportingService){
        this.reportingService= reportingService;
    }



}
