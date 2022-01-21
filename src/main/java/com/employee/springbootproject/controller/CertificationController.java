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
import com.employee.springbootproject.entity.Certification;
import com.employee.springbootproject.service.CertificationService;

@RestController
@RequestMapping("/certification")
@Validated
@CrossOrigin

public class CertificationController 
{
	@Autowired
	private CertificationService service;
	
	@PostMapping("/add")
	public String add(@RequestBody @Valid Certification certificate)
	{
		service.add(certificate);
		return "added";
	}
	
	@GetMapping("/all")
	public List<Certification> getCertificates()
	{
		return service.get();
	}
	
	@PutMapping(value="/{id}")
	public Certification update(@RequestBody @Valid Certification certificate, @PathVariable("id") int id)
	{
		 certificate= service.update(certificate, id);
		 return certificate;
	}
	
	@DeleteMapping(value="/{id}")
	public String delete(@PathVariable("id") int id)
	{
		 service.delete(id);
		 return "deleted row with id = "+ id;
	}
	
}

