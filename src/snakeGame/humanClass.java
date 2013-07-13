package snakeGame;

import snakeGame.Snake.Direction;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class humanClass extends gameClass {	
	public humanClass(int player) {
	}

	public void moveSnake(){//overwrite base class
		
	}
	
	class myListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (snake2_.isThisHuman()) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					snake2_.changeDir(Direction.UP);
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					snake2_.changeDir(Direction.RIGHT);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					snake2_.changeDir(Direction.DOWN);
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					snake2_.changeDir(Direction.LEFT);
				}
			}
			if (snake1_.isThisHuman()) {
				if (e.getKeyCode() == KeyEvent.VK_A) {
					snake1_.changeDir(Direction.LEFT);
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					snake1_.changeDir(Direction.DOWN);
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					snake1_.changeDir(Direction.RIGHT);
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					snake1_.changeDir(Direction.UP);
				}
			}
		}
	}
}