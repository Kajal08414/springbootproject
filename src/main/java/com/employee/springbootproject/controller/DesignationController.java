package com.employee.springbootproject.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.springbootproject.entity.Designation;
import com.employee.springbootproject.service.DesignationService;

@RestController
@RequestMapping("/designation")
@Validated
@CrossOrigin

public class DesignationController 
{
	
	@Autowired
	private DesignationService desigservice;
	
	@PostMapping("/add")
	public String addDesignation(@RequestBody @Valid Designation designation)
	{
		desigservice.addDesignation(designation);
		return "added";
	}
	
	@GetMapping("/all")
	public List<Designation> getDesignations()
	{
		return desigservice.getDesignations();
	}
	
	@PutMapping(value="/{id}")
	public Designation update( @RequestBody @Valid Designation designation, @PathVariable("id") int id)
	{
		 designation= desigservice.update(designation, id);
		 return designation;
	}
	
	@DeleteMapping(value="/{id}")
	public String deleteDesignation(@PathVariable("id") int id)
	{
		 desigservice.deleteDesignation(id);
		 return "deleted row with id = "+ id;
	}
	
}
