package com.codechallenge.service;

import org.springframework.stereotype.Service;

import com.codechallenge.model.Rover;

@Service
public class TurnRight implements ICommand{
    @Override
    public boolean execute(Rover rover) {
        rover.turnRight();
        return true;
    }
    
	@Override
	public String getCommand() {

		return "R";
	}
}
