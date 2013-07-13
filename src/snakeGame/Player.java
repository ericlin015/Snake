package snakeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import snakeGame.Snake.Direction;

public class Player {
	
	protected Snake snake_;
	protected boolean isHuman_;
	
	
	public Player(){
		//default constructor without parameter for children class
	}
	
	public void followFood(){
		//to be overriden by ai class
	}	
	
	public void move(){//to be overiden by AI class and human class	
	}
	
	public void grow(Food food){
		snake_.snakeGrow(food);
	}
	
	//accessors
	public void changeDir(Direction dir){
		snake_.changeDir(dir);
	}
	
	public Snake getSnake(){
		return snake_;
	}
	
	public boolean isHuman(){
		return isHuman_;
	}
	
}
