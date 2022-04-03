package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ItemRepositoryTest {
	@Autowired
	ItemRepository repository;
	@Sql("/sql/data.sql")
	@Test
	void testSelectAll() {
		repository.selectAll().forEach(System.out::println);
		assertEquals(28, repository.selectAll().size());
	}
}
