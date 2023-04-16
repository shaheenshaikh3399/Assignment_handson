package com.hansdon.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hansdon.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
