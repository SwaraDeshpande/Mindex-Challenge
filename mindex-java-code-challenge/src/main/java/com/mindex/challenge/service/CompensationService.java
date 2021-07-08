package com.mindex.challenge.service;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

import java.util.List;


public interface CompensationService {
    List<Compensation> readByEmployeeId(String employeeId);


    Compensation create(Compensation compensation);
}
