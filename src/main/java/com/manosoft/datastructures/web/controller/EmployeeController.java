package com.manosoft.datastructures.web.controller;

import com.manosoft.datastructures.model.Employee;
import com.manosoft.datastructures.web.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public Employee getEmployee(@RequestParam int employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

}
