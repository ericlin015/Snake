package snakeGame;

import java.awt.Graphics;

public interface game {
	public void generateFood();
	public boolean isEatingFood();
	public boolean isHittingWall();
	public boolean isHittingOther(Snake snake);
	public void paint(Graphics g);
	public boolean isGameOver(Snake snake1, Snake snake2);
}


