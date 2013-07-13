package snakeGame;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;

import snakeGame.Snake.Direction;

public class gameClass implements game{
	private Food food_;
	protected Snake snake1_;
	protected Snake snake2_;
	private boolean isGameOver_ = true;
	private Dimension dim;
	private gamePage g_;
	
	public gameClass(){
		//default constructor without parameter for children class
	}
	
	public void followFood(){
		//to be overriden by ai class
	}
	
	public void moveSnake(){
		//to be overriden by human class
	}
	
	public gameClass(gamePage g){
		snake1_ = new Snake(1);
		snake2_ = new Snake(2);
		food_ = new Food(snake1_,snake2_);
		isGameOver_ = false;
		g_ = g;
		g_.setVisible(true);
		dim = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public boolean isEatingFood(Snake snake){
		if(snake.getDir() == Direction.LEFT && food_.getFoodX() == snake.getSnakeX()[0]-5 && food_.getFoodY()==snake.getSnakeY()[0]){
			return true;
		}else if(snake.getDir() == Direction.RIGHT && food_.getFoodX() == snake.getSnakeX()[0] + 5 && food_.getFoodY()==snake.getSnakeY()[0]){
			return true;
		}else if(snake.getDir() == Direction.UP && food_.getFoodX() == snake.getSnakeX()[0] && food_.getFoodY()==snake.getSnakeY()[0] + 5){
			return true;
		}else if(snake.getDir() == Direction.DOWN && food_.getFoodX() == snake.getSnakeX()[0] && food_.getFoodY()==snake.getSnakeY()[0]-5){
			return true;
		}else{
			return false;
		}
	}
	public boolean isHittingWall(Snake snake){
		if(snake.getDir() == Direction.LEFT &&  snake.getSnakeX()[0] < 5 ){
			return true;
		}else if(snake.getDir() == Direction.RIGHT && snake.getSnakeX()[0] >= rightEdge ){
			return true;
		}else if(snake.getDir() == Direction.UP &&  snake.getSnakeY()[0] <5){
			return true;
		}else if(snake.getDir() == Direction.DOWN && snake.getSnakeY()[0] >=bottomEdge){
			return true;
		}else{
			return false;
		}
	}
	public boolean isHittingOther(Snake snake1, Snake snake2){//is snake1 hitting snake 2?
		if(snake1.getDir() == Direction.LEFT &&  snake1.getSnakeX()[0]-5 == snake2.getSnakeX()[0] ){
			return true;
		}else if(snake1.getDir() == Direction.RIGHT && snake1.getSnakeX()[0]+5  == snake2.getSnakeX()[0]  ){
			return true;
		}else if(snake1.getDir() == Direction.UP &&  snake1.getSnakeY()[0] -5== snake2.getSnakeY()[0] ){
			return true;
		}else if(snake1.getDir() == Direction.DOWN && snake1.getSnakeY()[0] +5== snake2.getSnakeY()[0]){
			return true;
		}else{
			return false;
		}
	}
	
	public void moveOn(){
		if(isEatingFood(snake1_)){
			snake1_.snakeGrow(food_);
			food_.makeNewFood(snake1_, snake2_);
		}else if(isEatingFood(snake2_)){
			snake2_.snakeGrow(food_);
			food_.makeNewFood(snake1_, snake2_);
		}
	}
	
	public void paint(Graphics g){
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 650, 330);
			g.setColor(Color.BLACK);//the dimension of the frame.
            g.fillRect(0, 0, 650, 5);
            g.fillRect(0, 325, 650, 5);
            g.fillRect(0, 0, 5, 330);
            g.fillRect(645, 0, 5, 330);
            int[] mysnakeX1 = snake1_.getSnakeX();
            int[] mysnakeY1 = snake1_.getSnakeY();
            int[] mysnakeX2 = snake2_.getSnakeX();
            int[] mysnakeY2 = snake2_.getSnakeY();
            for(int i =0;i<snake1_.getLength();i++){
            	g.fillRect(mysnakeX1[i], mysnakeY1[i],5, 5);          	
            }
            g.setColor(Color.RED);
            for(int i = 0;i<snake2_.getLength();i++){
            	g.fillRect(mysnakeX2[i], mysnakeY2[i],5, 5);
            }
            moveOn();
	}
	public void finalPaint(Graphics g){
		if(!isGameOver()){
			
		}
	}
	public boolean isGameOver(){
		return isGameOver_;
	}
	
}