package com.spring.springbootdemo.service;

import com.spring.springbootdemo.error.EmployeeNotFoundException;
import com.spring.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    List<Employee> employees=new ArrayList<>();

    public Employee save(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmployeeId().isEmpty())
            employee.setEmployeeId(UUID.randomUUID().toString());
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees.stream().filter(employee -> employee.getEmployeeId().equalsIgnoreCase(id)).findFirst().orElseThrow(()-> new EmployeeNotFoundException("Employee Not Found With Id : "+id));
    }

    @Override
    public String deletEmployeeById(String id) {
        Employee employee= employees.stream().filter(e-> e.getEmployeeId().equalsIgnoreCase(id)).findFirst().get();
        employees.remove(employee);
        return "Employee with Id : "+id+" Has been removed from the list";
    }
}
