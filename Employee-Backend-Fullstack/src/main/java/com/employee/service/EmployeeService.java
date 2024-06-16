package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Employee employee, long id);

	public Employee getEmployeeById(Long id);


	public List<Employee> getAllEmployees();

}
