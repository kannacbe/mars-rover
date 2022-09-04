package com.codechallenge.service;

import org.springframework.stereotype.Service;

import com.codechallenge.model.Rover;

@Service
public class MoveBackward implements ICommand{
    
    @Override
    public boolean execute(Rover rover) {
        return rover.backward();
    }
    
	@Override
	public String getCommand() {

		return "B";
	}
    
}