package com.example.demo.helper;

import com.example.demo.entity.Item;
import com.example.demo.form.ItemForm;

public class ItemHelper {
	public static Item convert(ItemForm itemForm) {
		Item item = new Item();
		item.setName(itemForm.getName());
		item.setPrice(itemForm.getPrice());
		item.setCategoryId(itemForm.getCategoryId());
		return item;
	} 
}
