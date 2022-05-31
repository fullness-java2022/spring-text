package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Item;

@Mapper
public interface ItemRepository {
	List<Item> selectAll();
	Item selectById(Integer id);
	Item selectByIdForUpdate(Integer id);
	void insert(Item item);
	void update(Item item);
	void delete(Item item);
}
