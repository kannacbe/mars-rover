package com.jpmc.codechallenge.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Admin
 * Class to test Mars rover input commands.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InputCommandControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void rotatingRightFromNorth() throws Exception {
		mockMvc.perform(get("/marsRover").param("commands", "R").param("intialPosition", "N,1,2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.finalCoordinate").value("1,2"))
				.andExpect(jsonPath("$.finalDirection").value("EAST"));
	}

	@Test
	public void rotatingLeftFromSouth() throws Exception {

		mockMvc.perform(get("/marsRover").param("commands", "L").param("intialPosition", "S,1,2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.finalCoordinate").value("1,2"))
				.andExpect(jsonPath("$.finalDirection").value("EAST"));
	}
	@Test
	public void rotatingRightFromSouth() throws Exception {
		mockMvc.perform(get("/marsRover").param("commands", "R").param("intialPosition", "S,1,2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.finalCoordinate").value("1,2"))
				.andExpect(jsonPath("$.finalDirection").value("WEST"));
	}

	@Test
	public void rotatingLeftFromNorth() throws Exception {

		mockMvc.perform(get("/marsRover").param("commands", "L").param("intialPosition", "N,1,2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.finalCoordinate").value("1,2"))
				.andExpect(jsonPath("$.finalDirection").value("WEST"));
	}
	@Test
	public void rotatingRightandTwoForward() throws Exception {
		mockMvc.perform(get("/marsRover").param("commands", "R,F,F").param("intialPosition", "N,1,2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.finalCoordinate").value("3,2"))
				.andExpect(jsonPath("$.finalDirection").value("EAST"));
	}

	@Test
	public void rotatingRightandThreeBackward() throws Exception {
		mockMvc.perform(get("/marsRover").param("commands", "R,B,B,B").param("intialPosition", "N,1,2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.finalCoordinate").value("-2,2"))
				.andExpect(jsonPath("$.finalDirection").value("EAST"));
	}

	@Test
	public void rotatingLeftandFourBackward() throws Exception {
		mockMvc.perform(get("/marsRover").param("commands", "L,B,B,B,B").param("intialPosition", "N,1,2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.finalCoordinate").value("5,2"))
				.andExpect(jsonPath("$.finalDirection").value("WEST"));
	}

	@Test
	public void rotatingLeftandTwoForward() throws Exception {
		mockMvc.perform(get("/marsRover").param("commands", "L,F,F").param("intialPosition", "N,1,2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().is(HttpStatus.OK.value())).andExpect(jsonPath("$.finalCoordinate").value("-1,2"))
				.andExpect(jsonPath("$.finalDirection").value("WEST"));
	}

	@Test
	public void passingInvalidCommand() throws Exception {
		mockMvc.perform(get("/marsRover").param("commands", "L,F,F,X").param("intialPosition", "N,1,2")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value())).andExpect(content().string("Invalid Command."));
	}

}