package com.example.demo;

import com.example.demo.controller.DemoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DemoController.class)
class DemoApplicationTests {

		@Autowired
		private MockMvc mockMvc;

		@Test
		void testBasicFunctionality() throws Exception {
			mockMvc.perform(get("/remove").param("value", "eloquent"))
					.andExpect(status().isOk())
					.andExpect(content().string("loquen"));

			mockMvc.perform(get("/remove").param("value", "country"))
					.andExpect(status().isOk())
					.andExpect(content().string("ountr"));

			mockMvc.perform(get("/remove").param("value", "person"))
					.andExpect(status().isOk())
					.andExpect(content().string("erso"));

			mockMvc.perform(get("/remove").param("value", "xyz"))
					.andExpect(status().isOk())
					.andExpect(content().string("y"));
		}

		@Test
		void testEdgeCases() throws Exception {
			mockMvc.perform(get("/remove").param("value", "ab"))
					.andExpect(status().isOk())
					.andExpect(content().string(""));

			mockMvc.perform(get("/remove").param("value", "a"))
					.andExpect(status().isBadRequest())
					.andExpect(content().string("Input must be at least 2 characters long"));

			mockMvc.perform(get("/remove").param("value", ""))
					.andExpect(status().isBadRequest())
					.andExpect(content().string("Input must be at least 2 characters long"));
		}

		@Test
		void testSpecialCharactersAndNumbers() throws Exception {
			mockMvc.perform(get("/remove").param("value", "123%qwerty+"))
					.andExpect(status().isOk())
					.andExpect(content().string("23%qwerty"));
		}
	}



