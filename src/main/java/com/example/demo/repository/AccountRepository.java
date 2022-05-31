package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Account;

@Mapper
public interface AccountRepository {
	void insert(Account account);
	Account selectByUserName(String userName);
}
