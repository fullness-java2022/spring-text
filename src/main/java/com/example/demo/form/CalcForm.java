package com.example.demo.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class CalcForm {
	@NotNull
	@Range(min=1,max=100)
	private Integer value1;
	@NotNull
	@Range(min=1,max=100)
	private Integer value2;
}
