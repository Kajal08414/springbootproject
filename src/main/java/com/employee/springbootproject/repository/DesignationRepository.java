package com.employee.springbootproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employee.springbootproject.entity.Designation;

@Repository

public interface DesignationRepository extends JpaRepository<Designation,Integer> 
{

}

