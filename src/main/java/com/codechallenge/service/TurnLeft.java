package com.codechallenge.service;

import org.springframework.stereotype.Service;

import com.codechallenge.model.Rover;

@Service
public class TurnLeft implements ICommand{
    @Override
    public boolean execute(Rover rover) {
        rover.turnLeft();
        return true;
    }
    
	@Override
	public String getCommand() {

		return "L";
	}
}