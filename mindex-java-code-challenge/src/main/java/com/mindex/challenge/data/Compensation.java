package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "compensation")
public class Compensation {
    @Id
    private String compensationId;

    private Employee employee;


    private double salary;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date effectiveDate;

    public Compensation(){

    }
    public String getCompensationId(){
        return  compensationId;
    }

    public void setCompensationId(String compensationId) {
        this.compensationId = compensationId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }


    public Date getEffectiveDate(){return effectiveDate;}

    public void setEffectiveDate(Date effectiveDate){this.effectiveDate = effectiveDate;}
}
