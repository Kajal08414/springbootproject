package com.employee.springbootproject.entity;
import javax.validation.constraints.Pattern;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter(value= AccessLevel.PUBLIC)
@Setter(value= AccessLevel.PUBLIC)

public class SearchCriteria 
{
	private String name;
	private String address;
	private Integer designation;
	@Pattern(message="please enter a valid salary", regexp = "[0-9]+")
	private String salary;
	public String getName() 
	{
		return name;
	}
}
