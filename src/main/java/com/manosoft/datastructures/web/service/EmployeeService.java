package com.manosoft.datastructures.web.service;

import com.manosoft.datastructures.model.Employee;
import com.manosoft.datastructures.web.repository.EmployeeRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    public static final String EMPLOYEE_CACHE = "employeeCache";
    private final EmployeeRespository employeeRespository;
    private final CacheService cacheService;

    public Employee getEmployee(int employeeId){
        Employee empCached = (Employee) cacheService.get(EMPLOYEE_CACHE, employeeId);
        if(empCached == null ){
            empCached = employeeRespository.findOneByEmployeeId(employeeId);
            cacheService.put(EMPLOYEE_CACHE, employeeId, empCached);
        }
        return empCached;
    }
    public Employee saveEmployee(Employee employee){
        if(employee != null ){
            employee = employeeRespository.save(employee);
            cacheService.put(EMPLOYEE_CACHE, employee.getEmployeeId(), employee);
        }
        return employee;
    }
}
