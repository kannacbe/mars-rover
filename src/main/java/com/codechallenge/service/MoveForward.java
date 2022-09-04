package com.codechallenge.service;

import org.springframework.stereotype.Service;

import com.codechallenge.model.Rover;

@Service
public class MoveForward implements ICommand{
    
    @Override
    public boolean execute(Rover rover) {
        return rover.forward();
    }

	@Override
	public String getCommand() {

		return "F";
	}
    
    
    
}