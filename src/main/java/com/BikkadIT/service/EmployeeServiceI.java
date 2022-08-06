package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.model.Employee;

public interface EmployeeServiceI {
	
	public Employee addEmployee(Employee employee);
	
	public List<String> addMultiEmployee(List<Employee> employees);
	
	public Employee getEmployeeById(int id);
	
	public List<Employee> getAllEmployee();
	
	public List<Employee> findByAgeLessThanOrEqual(int age);
	
	public Employee loginCheck(String name,int id);
	
	public Employee update(Employee employee);
	
	public List<Employee> updateMultiple(List<Employee> employees);
	
	public Employee delete(int id);
	
	public void deleteAll();

	List<String> addMultiEmployee1(List<Employee> employees);

	
	
}
