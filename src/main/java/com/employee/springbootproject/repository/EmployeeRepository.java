package com.employee.springbootproject.repository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.employee.springbootproject.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> 
{
	@Query(value="select e from Employee e where e.name like %:name%")
	List<Employee> findAllByname(@Param("name") String name);
	List<Employee> findAllBysalary(String salary);
	@Query(value="select e from Employee e where e.email =:email")
	List<Employee> findAllByemail(@Param("email") String email);
	@Query(value=" select e from Employee e where e.name =:name and e.email =:email")
	List<Employee>search(@Param("name") String name, @Param("email") String email);
	Integer countByemail(String email);
	Integer countByphone(String phone);
	Page<Employee> findAll(Pageable pageable);
}

