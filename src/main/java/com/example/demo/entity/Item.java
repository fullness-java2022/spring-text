package com.example.demo.entity;

import lombok.Data;

@Data
public class Item {
	private int id;
	private String name;
	private int price;
	private int categoryId;
	private ItemCategory itemCategory;
}
