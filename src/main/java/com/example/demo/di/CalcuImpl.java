package com.example.demo.di;

import org.springframework.stereotype.Component;

@Component
public class CalcuImpl {
	public Integer add(Integer x, Integer y) {
		return x + y;
	}
}
