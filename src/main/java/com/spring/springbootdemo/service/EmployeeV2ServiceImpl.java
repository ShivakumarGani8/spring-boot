package com.spring.springbootdemo.service;

import com.spring.springbootdemo.entity.EmployeeEntity;
import com.spring.springbootdemo.error.EmployeeNotFoundException;
import com.spring.springbootdemo.model.Employee;
import com.spring.springbootdemo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepo.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities= employeeRepo.findAll();
        return employeeEntities.stream().map(employeeEntity -> {
            Employee employee=new Employee();
            BeanUtils.copyProperties(employeeEntity,employee);
            return employee;
        }).collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity employeeEntity=employeeRepo.findById(id).get();
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public String deletEmployeeById(String id) {
        employeeRepo.deleteById(id);
        return "Employee deleted with ID: "+id;
    }
}
