package com.example.demo.form;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ItemForm implements Serializable{
	@NotBlank
	private String name;
	@Min(50)
	@NotNull
	private Integer price;
	private Integer categoryId;
}
