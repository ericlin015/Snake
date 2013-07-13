package snakeGame;

import java.awt.Graphics;

public interface GameInterface {
	public boolean isEatingFood(Snake snake);
	public boolean isHittingWall(Snake snake);
	public boolean isHittingOther(Snake snake1, Snake snake2);
	final static int rightEdge = 645;
	final static int bottomEdge = 325;
}


