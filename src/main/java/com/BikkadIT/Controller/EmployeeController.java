package com.BikkadIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Employee;
import com.BikkadIT.service.EmployeeServiceI;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	// Add Employee
	
	@PostMapping(value = "/add",produces = "application/json",consumes = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		Employee employee1 = employeeServiceI.addEmployee(employee);
		
		return new ResponseEntity<String>("Employee Data Added: "+employee1.getEmpId()+"---"+employee1.getEmpName(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/addMultiple",produces = "application/json",consumes = "application/json")
	public ResponseEntity<List<String>> saveMultiEmployee(@RequestBody List<Employee> employees)
	{
		 List<String> multiEmployee = employeeServiceI.addMultiEmployee(employees);
		
		return new ResponseEntity<List<String>>(multiEmployee, HttpStatus.OK);
	}
	
	
	
	//update
	
	@PostMapping(value = "/update",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Employee> update(@RequestBody Employee employee)
	{
		Employee employee2 = employeeServiceI.update(employee);
		
		if(employee2 != null)
		{
			 return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(employee2,HttpStatus.BAD_REQUEST);
		
	}	
		
		@PostMapping(value = "/updateMultiple",consumes = "application/json",produces = "application/json")
		public ResponseEntity<List<Employee>> updateMultiple(@RequestBody List<Employee> employees)
		{
			List<Employee> employees1 = employeeServiceI.updateMultiple(employees);
			
			if(employees1 != null)
			{
				return new ResponseEntity<List<Employee>>(employees1,HttpStatus.OK);
			}
			
		return new ResponseEntity<List<Employee>>(employees1,HttpStatus.BAD_REQUEST);
	}
	
	//Login Check
		
		@PostMapping(value = "/login",consumes = "application/json",produces = "application/json")
		public ResponseEntity<String> loginCheck(@RequestBody Employee employee)
		{
			Employee employee1 = employeeServiceI.loginCheck(employee.getEmpName(), employee.getEmpId());
			
			if(employee1 != null)
			{
				return new ResponseEntity<String>("successful login",HttpStatus.OK);
			}
			
			return new ResponseEntity<String>("login failed please check Id or Name",HttpStatus.BAD_REQUEST);
		}
		
		
	//	Get
		
		@GetMapping(value = "/getById/{id}",produces = "application/json")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
		{
			Employee employee = employeeServiceI.getEmployeeById(id);
			
			if(employee != null)
			{
				return new ResponseEntity<Employee>(employee,HttpStatus.OK);
			}
			
			return new ResponseEntity<Employee>(employee,HttpStatus.NO_CONTENT);
		}
		
		@GetMapping(value = "/getAllEmployee",produces = "application/json")
		public ResponseEntity<List<Employee>> getAllEmployee()
		{
			List<Employee> allEmployee = employeeServiceI.getAllEmployee();
			if(allEmployee !=null)
			{
			return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
		   	}
			
			return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.NO_CONTENT);
		}
		
		@GetMapping(value = "/getAllEmployee/{age}",produces = "application/json")
		public ResponseEntity<List<Employee>> getAllEmployeeLessThanOrEqual(@PathVariable int age)
		{
			List<Employee> allEmployee = employeeServiceI.findByAgeLessThanOrEqual(age);
			if(allEmployee !=null)
			{
			return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
		   	}
			
			return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.NO_CONTENT);
		}
		
		
	// 	Delete
		
		@GetMapping(value = "/deleteById/{id}")
		public ResponseEntity<String> delete(@PathVariable int id)
		{
			Employee employee = employeeServiceI.delete(id);
			
			if(employee != null)
			{
				return new ResponseEntity<String>("Data Deleted for Id : "+employee.getEmpId(),HttpStatus.OK);
			}
			
			return new ResponseEntity<String>("Data Can not delete because id is not matching",HttpStatus.OK);

		}
		
		@GetMapping("/deleteAll")
		public ResponseEntity<String> deleteAll()
		{
			employeeServiceI.deleteAll();
			
			return new ResponseEntity<String>("All Employees Data Deleted Successfully",HttpStatus.OK);
		}
	
}
