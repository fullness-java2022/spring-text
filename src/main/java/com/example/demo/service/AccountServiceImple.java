package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountServiceImple implements AccountService{
	@Autowired
	private AccountRepository repository;

	@Override
	public void addAccount(Account account) {
		repository.insert(account);
	}

}
