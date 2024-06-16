package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exceptionhandling.ResourceNotFoundException;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		 Employee updateEmployee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

	        updateEmployee.setFirstName(employee.getFirstName());
	        updateEmployee.setLastName(employee.getLastName());
	        updateEmployee.setEmailId(employee.getEmailId());
		return updateEmployee;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
