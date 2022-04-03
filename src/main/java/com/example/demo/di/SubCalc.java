package com.example.demo.di;

import org.springframework.stereotype.Component;

@Component
public class SubCalc implements Calculator{
	@Override
	public Integer calc(Integer x, Integer y) {
		return x - y;
	}
}
