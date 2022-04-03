package com.example.demo.di;

import org.springframework.stereotype.Component;

@Component
public class AddCalc implements Calculator{
	@Override
	public Integer calc(Integer x, Integer y) {
		return x + y;
	}
}
