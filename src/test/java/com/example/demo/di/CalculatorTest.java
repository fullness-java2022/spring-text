package com.example.demo.di;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CalculatorTest {
	@Autowired
	private Calculator addCalc;
	@Autowired
	private Calculator subCalc;
	@Test
	void testAddCalc() {
		assertEquals(3, addCalc.calc(1, 2));
	}
	@Test
	void testSubCalc() {
		assertEquals(2, subCalc.calc(5,3));
	}
}
