package com.employee.springbootproject.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.employee.springbootproject.controller.EmployeeController;
import com.employee.springbootproject.entity.Employee;
import com.employee.springbootproject.entity.EmployeePage;
import com.employee.springbootproject.entity.SearchCriteria;
import com.employee.springbootproject.exception.InvalidException;
import com.employee.springbootproject.repository.EmployeeRepository;
import com.employee.springbootproject.repository.EmployeeSearchCriteriaRepository;

@Service
public class EmployeeService 
{
	 private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);
	 
	@Autowired
	EmployeeRepository repos;
	
	@Autowired
	EmployeeSearchCriteriaRepository crepo; 

	public Exception saveEmployee( Employee employee) throws InvalidException
	{
		
		int ecount=repos.countByemail(employee.getEmail());
		int pcount=repos.countByphone(employee.getPhone());
		String name=employee.getName().toLowerCase();
		log.error(employee.getCertificates()+"here is the list");
		log.error("count "+ ecount);
		try
		{
			if(ecount>=1)
			{
				throw new InvalidException(employee.getEmail()+" is already registered !!! try with some other email");
			}else if(pcount>=1)
			{
				throw new InvalidException(employee.getPhone()+" is already registered !!! try with some other number");
			}else {
				employee.setName(name);
			
			repos.save(employee);
			}
	    }catch(InvalidException e)
		{
	    	log.error("System Error: "+e.getMessage());
			return e;	
		}
		return null;
     }

	@Cacheable(cacheNames = "cacheStore", key = "'+#pageSize''+#pageNumber'")
	public Page<Employee> getAllEmployee(int pageSize,int pageNumber) 
	{
		Pageable paging = PageRequest.of(pageNumber, pageSize);
		Page<Employee> employees =repos.findAll(paging);
		return employees;
	}
	
	public Employee updateEmployee(Employee employee, int id) 
	{
		employee.setId(id);
		String name=employee.getName().toLowerCase();		
	    try {
	    log.error("havnt saved yet!!!!");
	    employee.setName(name);	
		repos.save(employee);
		return employee;
	    }catch(Exception e)
	    {
	    	employee=null;
	    	log.error("System Error: "+e.getMessage());
	    }
		return employee;
	}
	
	public void deleteEmployee(int id) 
	{
		 repos.deleteById(id);
	}

	@Cacheable(cacheNames = "cacheStore", key = "#id")
	public Employee findEmployeeById(int id) 
	{
		Employee employee=repos.findById(id).orElseThrow();
		return employee;
	}

	@Cacheable(cacheNames = "cacheStore", key = "#name")
	public List<Employee> searchByName(String name) 
	{
		return repos.findAllByname(name);
	}
	
	@Cacheable(cacheNames = "cacheStore", key = "#name")
    public List<Employee>searchBySalary(String name) 
	{
		return repos.findAllBysalary(name);
	}
	
	@Cacheable(cacheNames = "cacheStore", key = "'+#name''+#email'")
	public List<Employee> search(String name, String email) 
	{
		return repos.search(name,email);
	}
     
     public Page<Employee> getEmployees(EmployeePage employeePage,SearchCriteria employeeSearchCriteria)
     {
    	 return crepo.findAllWithFilters(employeePage, employeeSearchCriteria);
     }
     
     public boolean findId(int id) 
     {
		return repos.existsById(id);
	 }
     
}
