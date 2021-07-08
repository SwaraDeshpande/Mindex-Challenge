package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }

    @Override
    public ReportingStructure readReportingStructureByEmployeeId(String employeeId){
        LOG.debug("Reading reporting structure employee [{}]",employeeId);


        ReportingStructure reportingStructure = new ReportingStructure();
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        reportingStructure.setEmployee(employee);
        List<Employee> directReportsList = employee.getDirectReports();
        int numberOfReports = 0;
        if(!CollectionUtils.isEmpty(directReportsList)) {
            for(Employee directReport: directReportsList){

                Employee emp = employeeRepository.findByEmployeeId(directReport.getEmployeeId());
                numberOfReports++;
                numberOfReports = numberOfReports + getDirectReport(emp);
            }
        }
        reportingStructure.setNumberOfReports(numberOfReports);

        return  reportingStructure;
    }

    private int getDirectReport(Employee employee) {
        List<Employee> directReportsList = employee.getDirectReports();
        int numberOfReports = 0;
        if(!CollectionUtils.isEmpty(directReportsList)) {
            for (Employee directReport : directReportsList) {
                Employee emp = employeeRepository.findByEmployeeId(directReport.getEmployeeId());
                numberOfReports++;
                numberOfReports = numberOfReports + getDirectReport(emp);
            }
        }
        return  numberOfReports;
    }

}
