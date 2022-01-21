package com.employee.springbootproject.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Certification")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter(value= AccessLevel.PUBLIC)
@Setter(value= AccessLevel.PUBLIC)
@Entity

public class Certification 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotEmpty(message ="Please enter a name")
	@NotNull(message ="Please enter a name")
	private String name;
}

