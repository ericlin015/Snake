package snakeGame;

import java.awt.Graphics;

public interface game {
	public boolean isEatingFood(Snake snake);
	public boolean isHittingWall(Snake snake);
	public boolean isHittingOther(Snake snake1, Snake snake2);
	public boolean isGameOver();
	final static int rightEdge = 645;
	final static int bottomEdge = 325;
}


