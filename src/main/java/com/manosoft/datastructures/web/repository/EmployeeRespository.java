package com.manosoft.datastructures.web.repository;


import com.manosoft.datastructures.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {

    Employee findOneByEmployeeId(int empId);
}
