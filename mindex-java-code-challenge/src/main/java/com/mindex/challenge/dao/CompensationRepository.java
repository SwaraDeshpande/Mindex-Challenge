package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String>{

  //  Compensation findByCompensationId(String compensationId);

    List<Compensation> findByEmployee(Employee employeeId);
}
