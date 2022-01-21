package com.employee.springbootproject.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import com.employee.springbootproject.annotations.Name;
import com.employee.springbootproject.annotations.Phone;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor(access= AccessLevel.PUBLIC)
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@Getter(value= AccessLevel.PUBLIC)
@Setter(value= AccessLevel.PUBLIC)
@Table(name="Employee", uniqueConstraints=@UniqueConstraint(columnNames= {"email"}))

public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Designation designation;
	@ManyToMany
	private Set<Certification> certificates = new HashSet<Certification>();
	
	@NotEmpty(message ="Please enter a name")
	@NotNull(message ="Please enter a name")
	@Name(message="Name is invalid")
	private String name;
	
	@NotEmpty(message = "Please enter an address")
	@NotNull(message="address field is empty")
	private String address;
	
	@NotEmpty(message = "Please enter salary")
	@NotNull(message="Salary field is empty")
	@Pattern(regexp="[0-9]+", message= "please enter a valid salary")
	private String salary;
	
	@NotEmpty(message = "Please enter an email")
	@NotNull(message="email field is empty")
	@Email(message="Please enter correct email")
	private String email;
	
	@NotEmpty(message = "Please enter a phone number")
	@NotNull(message="phone field is empty")
	@Phone(message="please enter numbers only in phone field")
	@Length(min = 10, max = 10, message="Incorrect Phone number")
	private String phone;
}
