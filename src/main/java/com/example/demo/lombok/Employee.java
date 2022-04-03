package com.example.demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {
	private int empNo;
	private String empName;
}
