package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Compensation create(Compensation compensation){
        LOG.debug("Creating compensation [{}]", compensation);

        compensation.setCompensationId(UUID.randomUUID().toString());
        compensationRepository.insert(compensation);

        return compensation;

    }

    public List<Compensation> readByEmployeeId(String employeeId) {
        LOG.debug("Finding compensation by employeeId [{}]", employeeId);

        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        List<Compensation> compensationList = compensationRepository.findByEmployee(employee);
        return compensationList;

    }


}
