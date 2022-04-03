package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.ItemCategory;

@Mapper
public interface ItemCategoryRepository {
	List<ItemCategory> selectAll();
}
