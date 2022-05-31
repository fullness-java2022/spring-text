package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CalcControllerTest {
	@Autowired CalcController controller;
	MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testEnter() throws Exception{
		mockMvc.perform(get("/calc"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("calc/enter"));
	}

	@Test
	public void testResultOk() throws Exception{
		MvcResult mvcResult = mockMvc.perform(post("/calc")
				.param("value1", "10")
				.param("value2", "20"))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("calc/result")).andReturn();
		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		assertEquals(30, (Integer)modelMap.get("result"));

	}
}
