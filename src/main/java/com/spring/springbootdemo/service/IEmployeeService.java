package com.spring.springbootdemo.service;

import com.spring.springbootdemo.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deletEmployeeById(String id);
}
