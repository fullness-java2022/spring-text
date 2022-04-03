package com.example.demo.lombok;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
	@Test
	void testEmployee() {
		Employee employee = new Employee(1, "山田太郎");
		assertEquals(1, employee.getEmpNo());
		assertEquals("山田太郎", employee.getEmpName());
	}
}
