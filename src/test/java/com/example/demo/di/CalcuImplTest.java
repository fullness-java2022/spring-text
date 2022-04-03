package com.example.demo.di;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CalcuImplTest {
	@Autowired
	private CalcuImpl calcuImpl;
	
	@Test
	void testAdd() {
		assertEquals(3, calcuImpl.add(2, 1));
	}
}
