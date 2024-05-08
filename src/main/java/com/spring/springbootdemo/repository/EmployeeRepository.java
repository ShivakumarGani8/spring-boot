package com.spring.springbootdemo.repository;

import com.spring.springbootdemo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
}
