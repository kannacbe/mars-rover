package com.codechallenge.model;

/**
 * @author Admin
 * Directions and the coordinate values for movement
 */
public enum Direction{
    N (0,1,"NORTH"), 
    S (0,-1,"SOUTH"),
    W (-1,0,"WEST"),
    E (1,0,"EAST");
    
    private int xStep;
    private int yStep;
    private String value;


    private Direction(int xStep, int yStep,String value){
        this.xStep = xStep;
        this.yStep = yStep;
        this.value = value;
    }
    public int getXStep(){
        return this.xStep;
    }
    public int getYStep(){
        return this.yStep;
    }
    public String getValue(){
        return this.value;
    }
    
    
}