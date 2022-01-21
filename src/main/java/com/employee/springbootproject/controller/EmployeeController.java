package com.employee.springbootproject.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.employee.springbootproject.entity.Employee;
import com.employee.springbootproject.entity.EmployeePage;
import com.employee.springbootproject.entity.Errors;
import com.employee.springbootproject.entity.SearchCriteria;
import com.employee.springbootproject.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@Validated
@CrossOrigin

public class EmployeeController 
{
	 private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeservice;
			
	@PostMapping(value="/add")
	public ResponseEntity<String> addEmployee( @RequestBody @Valid Employee employee)
	{    
		ResponseEntity<String> response = null;
		try 
		{
			if(employeeservice.saveEmployee(employee)!=null)
			{
				response= new ResponseEntity<String>(employeeservice.saveEmployee(employee).getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); 	
				
			}else
			{
				
				response= new ResponseEntity<String>("Thank you for Register!!!",HttpStatus.OK); 
			}
		}catch(Exception e)
		{
			 response= new ResponseEntity<String>("This data already exists... You cannot register",HttpStatus.INTERNAL_SERVER_ERROR); 
		}	 
		 return response;
	}
	
	@GetMapping(value="/all")
	public Page<Employee> getAllEmployee(@RequestParam("pageSize") Integer pageSize,@RequestParam("pageNumber") Integer pageNumber) throws Exception
	{ 
		try {		
		 return employeeservice.getAllEmployee(pageSize,pageNumber);
		}catch(Exception e)
		{
			 throw e;
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Employee> updateEmployee( @RequestBody @Valid Employee employee, @PathVariable("id") Integer id)
	{
		 ResponseEntity<Employee> response = null;
         try 
         {
             employee = employeeservice.updateEmployee(employee, id);
             response = new ResponseEntity<Employee>(employee,HttpStatus.OK);
         }catch(Exception e) 
         {
             log.error(e.getMessage());
         }
         return response;
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Errors> deleteEmployee(@PathVariable("id") Integer id)
	{
		 employeeservice.deleteEmployee(id);
		 ResponseEntity<Errors> response = null;
		try 
		{
			return response;

        }catch(Exception e) {
            log.error(e.getMessage());
            log.error("System Error: "+e.getMessage());
            return response;
        }
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Integer id)
	{ 
		Employee employee;
		 ResponseEntity<Employee> response = null;
		         try 
		         {
		        	 employee = employeeservice.findEmployeeById(id);
		             response = new ResponseEntity<Employee>(employee,HttpStatus.OK);
		         }catch(Exception e) 
		         {
		             log.error(e.getMessage());
		         }
		         return response;
	}
	
	@GetMapping(value="/search/{name}")
	public List<Employee> searchByName(@PathVariable("name") String name)
	{
		 return employeeservice.searchByName(name);
	}
	
	@GetMapping(value="/searchBySalary/{salary}")
	public List<Employee>searchBySalary(@Valid @PathVariable("salary") String salary)
	{
		 return employeeservice.searchBySalary(salary);
	}
	
	@GetMapping(value="/search")
	public List<Employee> search( @Valid @RequestParam("name") String name,@RequestParam("email") String email)
	{
		 return employeeservice.search(name, email);
	}
	
	@PostMapping(value="/searches")
	public ResponseEntity<Page<Employee>>searches(EmployeePage employeePage ,@RequestBody SearchCriteria employeeSearchCriteria)
	{
		 return new ResponseEntity<>(employeeservice.getEmployees(employeePage,employeeSearchCriteria),HttpStatus.OK);
	}

}
