package com.example.demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class ItemCategory {
	private int id;
	private String name;
	private List<Item> items;
}
