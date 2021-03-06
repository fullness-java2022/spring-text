package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Item;

@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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
	void testSelectById() {
		Item item = repository.selectById(1);
		System.out.println(item);
		assertEquals(1, item.getId());
		assertEquals("水性ボールペン(黒)", item.getName());
		assertEquals(120, item.getPrice());
		assertEquals(1, item.getCategoryId());
	}

	@Sql("/sql/data.sql")
	@Test
	void testInsert() {
		Item item = new Item(null,"テスト商品",100,1,null);
		repository.insert(item);
		repository.selectAll().forEach(System.out::println);
		assertEquals(29, repository.selectAll().size());
	}

	@Sql("/sql/data.sql")
	@Test
	void testUpdate() {
		Item item = new Item(1,"テスト商品",100,1,null);
		repository.update(item);
		repository.selectAll().forEach(System.out::println);
		assertEquals(28, repository.selectAll().size());
	}

	@Sql("/sql/data.sql")
	@Test
	void testUpdatePessimisticLock() {
		Item item = repository.selectByIdForUpdate(3);
		item.setName("テスト商品");
		item.setPrice(1000);
		item.setCategoryId(2);
		repository.update(item);
		repository.selectAll().forEach(System.out::println);
		Item updatedItem = repository.selectById(3);
		assertEquals("テスト商品", updatedItem.getName());
		assertEquals(1000, updatedItem.getPrice());
		assertEquals(2, updatedItem.getCategoryId());
	}
}
