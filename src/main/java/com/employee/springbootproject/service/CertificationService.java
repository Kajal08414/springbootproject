package com.employee.springbootproject.service;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.springbootproject.entity.Certification;
import com.employee.springbootproject.repository.CertificateRepository;

@Service
public class CertificationService 
{
	
	@Autowired
	CertificateRepository repo;
	
	public void add(Certification certificate) 
	{
		repo.save(certificate);
	}

	public List<Certification> get() 
	{
		return repo.findAll();
	}
	
	public Certification update(@Valid Certification certificate, int id) 
	{
		certificate.setId(id);
		repo.save(certificate);
		return certificate;
	}

	public void delete(int id) 
	{
		repo.deleteById(id);
	}
	
}
