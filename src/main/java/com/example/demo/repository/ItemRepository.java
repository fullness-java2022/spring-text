package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Item;

@Mapper
public interface ItemRepository {
	List<Item> selectAll();
	void insert(Item item);
}
