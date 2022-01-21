package com.employee.springbootproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employee.springbootproject.entity.Certification;

@Repository

public interface CertificateRepository extends JpaRepository<Certification,Integer> 
{

}