package com.hansdon.app.service;

import com.hansdon.app.entity.Employee;

public interface EmployeeService {
	
	public Employee getAllEmployee();
	
	public Employee addEmployee();
	
	public Employee updateEmployee();
	
	public Integer getEmpBasedOnId();
	

}
