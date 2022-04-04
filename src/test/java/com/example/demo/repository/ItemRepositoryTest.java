package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Item;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ItemRepositoryTest {
	@Autowired
	private ItemRepository repository;
	@Sql("/sql/data.sql")
	@Test
	void testSelectAll() {
		repository.selectAll().forEach(System.out::println);
		assertEquals(28, repository.selectAll().size());
	}
	@Sql("/sql/data.sql")
	@Test
	void testInsert() {
		Item item = new Item();
		item.setName("テスト商品");
		item.setPrice(100);
		item.setCategoryId(1);
		repository.insert(item);
		repository.selectAll().forEach(System.out::println);
		assertEquals(29, repository.selectAll().size());
	}
}
