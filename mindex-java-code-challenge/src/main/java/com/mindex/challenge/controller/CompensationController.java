package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompensationController {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;


    @GetMapping("/compensation/read/{employeeId}")
    public List<Compensation> readByEmployeeId(@PathVariable String employeeId){
        LOG.debug("Reading Compensation by given employee id[{}]", employeeId);
        return compensationService.readByEmployeeId(employeeId);

    }

    @PostMapping("/compensation/create")
    public Compensation create(@RequestBody Compensation compensation){
        LOG.debug("Creating Compensation [{}]", compensation);
        return compensationService.create(compensation);
    }
}
