package com.employee.springbootproject.service;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.springbootproject.entity.Designation;
import com.employee.springbootproject.repository.DesignationRepository;

@Service
public class DesignationService 
{

	@Autowired
	DesignationRepository repos;
	
	public void addDesignation(Designation designation) 
	{
		repos.save(designation);
	}
	
	public List<Designation> getDesignations() 
	{
		return repos.findAll();
	}
	
	public  Designation update(@Valid Designation designation, int id) 
	{
		designation.setId(id);
		repos.save(designation);
		return designation;
	}

	public void deleteDesignation(int id) 
	{
		repos.deleteById(id);
		
	}
	
}
