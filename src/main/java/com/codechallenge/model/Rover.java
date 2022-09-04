package com.codechallenge.model;

/**
 * @author Admin
 * Class to hold the Rover current position.
 */
public class Rover {

	private Coordinates coordinates;
	private Direction direction;

	public Rover(Direction direction, Coordinates coordinates) {
		this.direction = direction;
		this.coordinates = coordinates;
	}

	public boolean forward() {
		this.coordinates.setX(calcNextStepX());
		this.coordinates.setY(calcNextStepY());
		return true;
	}

	public boolean backward() {
		this.coordinates.setX(calcBackStepX());
		this.coordinates.setY(calcBackStepY());
		return true;
	}

	private int calcNextStepX() {
		return this.coordinates.getX() + direction.getXStep();
	}

	private int calcNextStepY() {
		return this.coordinates.getY() + direction.getYStep();
	}

	private int calcBackStepX() {
		return this.coordinates.getX() - direction.getXStep();
	}

	private int calcBackStepY() {
		return this.coordinates.getY() - direction.getYStep();
	}

	public void turnLeft() {
		if (this.direction == Direction.N)
			this.direction = Direction.W;
		else if (this.direction == Direction.W)
			this.direction = Direction.S;
		else if (this.direction == Direction.S)
			this.direction = Direction.E;
		else if (this.direction == Direction.E)
			this.direction = Direction.N;
	}

	public void turnRight() {
		if (this.direction == Direction.N)
			this.direction = Direction.E;
		else if (this.direction == Direction.E)
			this.direction = Direction.S;
		else if (this.direction == Direction.S)
			this.direction = Direction.W;
		else if (this.direction == Direction.W)
			this.direction = Direction.N;
	}

	public String getFinalCoordinate() {
		return coordinates.getX() + "," + coordinates.getY();
	}

	public String getFinalDirection() {
		return direction.getValue();
	}

}
