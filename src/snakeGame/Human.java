package snakeGame;

import snakeGame.Snake.Direction;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Human extends Player {	
	public Human(int playNum) {
		isHuman_ = true;
		snake_ = new Snake(playNum);		
	}
	
	public void move(){//override the base class
		snake_.snakeMove();
	}
		
}