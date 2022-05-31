package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Account;
import com.example.demo.entity.AccountRole;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AccountServiceTest {
	@Autowired
	AccountService service;
	@Autowired
	PasswordEncoder encoder;

	@Test
	void testAddAccount() {
		service.addAccount(new Account(null, "takahashi", encoder.encode("passtakahashi"), new AccountRole(1, "admin")));
		service.addAccount(new Account(null, "kato", encoder.encode("passkato"), new AccountRole(2, "user")));
		service.addAccount(new Account(null, "sato", encoder.encode("passsato"), new AccountRole(3, "guest")));
	}
}
