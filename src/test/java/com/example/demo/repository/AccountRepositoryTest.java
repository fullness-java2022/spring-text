package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AccountRepositoryTest {
	@Autowired
	private AccountRepository repository;

	@Test
	void testSelectByUserName() {
		System.out.println(repository.selectByUserName("takahashi"));
	}
}
