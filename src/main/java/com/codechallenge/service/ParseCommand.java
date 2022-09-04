package com.codechallenge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.codechallenge.exception.BadRequestException;
import com.codechallenge.model.Coordinates;
import com.codechallenge.model.Direction;
import com.codechallenge.model.Rover;


@Component
public class ParseCommand {
	
	private Map<String, ICommand> commandMap = new HashMap<String, ICommand>();
	
	public ParseCommand(List<ICommand> commands ) {
		commands.stream().forEach( command -> commandMap.put(command.getCommand(), command));
	}
	
	
	public List<ICommand> parseMovement(String inputcommands) {
		
		List<ICommand> commands = new ArrayList<ICommand>();
		for(String input : Arrays.asList(inputcommands.split(","))) {
			if(commandMap.containsKey(input)) {
				commands.add(commandMap.get(input));
			} else {
				throw new BadRequestException("Invalid Command.");
			}
			
		}
		return commands;
	
	}

	public static Rover parsePosition(String intialPostion) {
		List<String> commands = Arrays.asList(intialPostion.split(","));
		int intialX = Integer.parseInt(commands.get(1));
		int intialY = Integer.parseInt(commands.get(2));
		return new Rover(Direction.valueOf(commands.get(0)), new Coordinates(intialX, intialY));
	}
}
