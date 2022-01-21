package com.employee.springbootproject.entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor(access= AccessLevel.PUBLIC)
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@Getter(value= AccessLevel.PUBLIC)
@Setter(value= AccessLevel.PUBLIC)

public class Errors 
{
	private Integer status;
	private String message;
	public Integer getStatus() 
	{
		return status;
	}
}
