package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
	private Integer id;
	private String name;
	private Integer price;
	private Integer categoryId;
	private ItemCategory itemCategory;
}
