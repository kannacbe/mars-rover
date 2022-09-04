package com.codechallenge.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.model.Rover;
import com.codechallenge.service.ICommand;
import com.codechallenge.service.ParseCommand;

/**
 * @author Admin
 * REST API call to invoke the Mars Rover.
 */
@RestController
public class InputCommandController {
	private static final Logger logger = LoggerFactory.getLogger(InputCommandController.class);

	@Autowired
	private ParseCommand parseCommand;
	
	/**
	 * This method calcuates the final postion of the Mars Rover after executing the list of commands.
	 * @param commands List of commands for the mars Rover
	 * @param intialPostion Intial position of the Rover.
	 * @return Final position and direction
	 */
	@RequestMapping("/marsRover")
	public ResponseEntity<Rover> receiveCommand(@RequestParam(value = "commands") String commands,
			@RequestParam(value = "intialPosition") String intialPostion) {
			Rover rover = ParseCommand.parsePosition(intialPostion);
			List<ICommand> commandList = parseCommand.parseMovement(commands);
			logger.info("Request commands:" + commands + " Intial Params : " + intialPostion);
			commandList.stream().forEach(command-> command.execute(rover));
			return ResponseEntity.ok(rover);
	}
}
