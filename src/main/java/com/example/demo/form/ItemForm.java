package com.example.demo.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemForm implements Serializable{
	private String itemName;
	private Integer itemPrice;
}
