package com.codechallenge.service;

import com.codechallenge.model.Rover;

public interface ICommand{
	
	
	String getCommand();
	
	boolean execute(Rover rover);
}
