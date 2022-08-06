package com.BikkadIT.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.model.Employee;
import com.BikkadIT.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		Employee employee1 = employeeRepository.save(employee);
		return employee1;
	}

	
	

	@Override
	public Employee getEmployeeById(int id) {
		
	    Employee employee = employeeRepository.findById(id).get();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	}

	@Override
	public List<Employee> findByAgeLessThanOrEqual(int age) {
		
		List<Employee> findByAgeLessThanOrEqual = employeeRepository.findByEmpAgeLessThanEqual(age);
		return findByAgeLessThanOrEqual;
	}

	@Override
	public Employee loginCheck(String name, int id) {
		
		Employee employee = employeeRepository.findByEmpNameAndEmpId(name, id);
		return employee;
	}

//	@Override
//	public Employee update(Employee employee) {
//		List<Employee> employees = employeeRepository.findAll();
//		Predicate<Employee> p=emp->emp.getEmpId()==employee.getEmpId();
//		
//		for(Employee emp:employees)
//		{
//			if(p.test(emp))
//			{
//				Employee employee1 = employeeRepository.save(employee);
//				return employee1;
//			}
//		}
//		return null;
//	}

	@Override
	public List<Employee> updateMultiple(List<Employee> employees) {
		List<Employee> all = employeeRepository.findAll();
		List<Employee> list=new ArrayList<>();
		for(Employee e:all)
		{
			for(Employee e1:employees)
			{
				if(e.getEmpId()==e1.getEmpId())
				{
					Employee employee = employeeRepository.save(e1);
					list.add(employee);
				}
			}
		}
		return list;
	}

	@Override
	public Employee delete(int id) {
		Employee employee = employeeRepository.findById(id).get();
		
		if(employee != null)
		{
			employeeRepository.deleteById(id);
			return employee;
		}
		return employee;
	}

	@Override
	public void deleteAll() {
				
		employeeRepository.deleteAll();
		
	}

	@Override
	public List<String> addMultiEmployee(List<Employee> employees) {
		// TODO Auto-generated method stub
		List<Employee> saveAll = employeeRepository.saveAll(employees);
		List<String> l=new ArrayList<>();
		for(Employee e:saveAll)
		{
			l.add("Employee Saved With Id And Name : "+e.getEmpId()+"---"+e.getEmpName());
		}
		return l;
		
	}




	@Override
	public List<String> addMultiEmployee1(List<Employee> employees) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
