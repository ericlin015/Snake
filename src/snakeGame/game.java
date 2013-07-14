package snakeGame;

import java.awt.Graphics;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;

import snakeGame.Snake.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game implements GameInterface{
	private Player player1_;
	private Player player2_;
	private Food food_;
	private boolean foodEaten_;
	private boolean isGameOver_ = true;
	private Dimension dim;
	private int winner;
	
	public Game(){
		player1_ = new Human(1);
		player2_ = new Human(2);
		food_ = new Food(player1_.getSnake(),player2_.getSnake());
		isGameOver_ = false;
	}
	
	public void fillSnake(Graphics g){
		g.setColor(Color.BLACK);
		int[] mysnakeX1 = player1_.getSnake().getSnakeX();
        int[] mysnakeY1 = player1_.getSnake().getSnakeY();
        int[] mysnakeX2 = player2_.getSnake().getSnakeX();
        int[] mysnakeY2 = player2_.getSnake().getSnakeY();
        for(int i =0;i<player1_.getSnake().getLength();i++){
        	g.fillRect(mysnakeX1[i], mysnakeY1[i],5, 5);          	
        }
        g.setColor(Color.RED);
        for(int i = 0;i<player2_.getSnake().getLength();i++){
        	g.fillRect(mysnakeX2[i], mysnakeY2[i],5, 5);
        }
	}
	
	public void fillFood(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(food_.getFoodX(),food_.getFoodY(),5,5);
		System.out.println("new food created " + food_.getFoodX() + " " + food_.getFoodY());
	}
	
	public void init(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 650, 330);
		g.setColor(Color.BLACK);//the dimension of the frame.
        g.fillRect(0, 0, 650, 5);
        g.fillRect(0, 325, 650, 5);
        g.fillRect(0, 0, 5, 330);
        g.fillRect(645, 0, 5, 330);
        g.fillRect(food_.getFoodX(), food_.getFoodY(), 5, 5);//food initialition
        System.out.println(food_.getFoodX() + " " + food_.getFoodY() + "created");
        foodEaten_ = false;
        fillSnake(g);
        //moveOn();
	}
	
	public void update(){
		if(isEatingFood(player1_.getSnake())){
			player1_.grow(food_);
			foodEaten_ = true;
			System.out.println("Player 1 eat food and grow");
		}else if(isEatingFood(player2_.getSnake())){
			player2_.grow(food_);
			foodEaten_ = true;
			System.out.println("Player 2 eat food and grow");
		}
		if(isHittingWall(player1_.getSnake())){
			isGameOver_ = true;
			winner = 2;
			System.out.println("Player 1 hitWall");
		}else if(isHittingWall(player2_.getSnake())){
			isGameOver_ = true;
			winner = 1;
			System.out.println("Player 2 hit wall");
		}
		if(isHittingOther(player1_.getSnake(),player2_.getSnake())){
			isGameOver_ = true;
			winner = 2;
			System.out.println("Player 1 hit player 2");
		}else if(isHittingOther(player2_.getSnake(),player1_.getSnake())){
			isGameOver_ = true;
			winner = 1;
			System.out.println("Player 2 hit player 1");
		}
		if(!isGameOver()){
			player1_.move();
			player2_.move();
			System.out.println(player2_.snake_.getSnakeX()[0]+ " "+player2_.snake_.getSnakeY()[0]);
		}
	}
	
	public void paint(Graphics g) {
		if (!isGameOver()) {
			g.setColor(Color.WHITE);
			g.fillRect(5, 5, 640, 320);
			fillSnake(g);
			fillFood(g);
			update();			
		}		
		if(foodEaten_){
			food_.makeNewFood(player1_.getSnake(), player2_.getSnake());
			foodEaten_ = false;
		}
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

	public boolean isHittingOther(Snake snake1, Snake snake2) {// is snake1
																// hitting snake
																// 2?
		for (int i = 0; i < snake2.getLength(); i++) {
			if (snake1.getDir() == Direction.LEFT
					&& snake1.getSnakeX()[0] - 5 == snake2.getSnakeX()[i]
					&& snake1.getSnakeY()[0] == snake2.getSnakeY()[i]) {
				return true;
			} else if (snake1.getDir() == Direction.RIGHT
					&& snake1.getSnakeX()[0] + 5 == snake2.getSnakeX()[i]
					&& snake1.getSnakeY()[0] == snake2.getSnakeY()[i]) {
				return true;
			} else if (snake1.getDir() == Direction.UP
					&& snake1.getSnakeY()[0] - 5 == snake2.getSnakeY()[i]
					&& snake1.getSnakeX()[0] == snake2.getSnakeX()[i]) {
				return true;
			} else if (snake1.getDir() == Direction.DOWN
					&& snake1.getSnakeY()[0] + 5 == snake2.getSnakeY()[i]
					&& snake1.getSnakeX()[0] == snake2.getSnakeX()[i]) {
				return true;
			}
		}
		return false;
	}
	

	public void keyPressed(KeyEvent e){
		if (player2_.isHuman()) {
			if (e.getKeyCode() == KeyEvent.VK_UP && player2_.getSnake().getDir() != Direction.DOWN) {
				player2_.changeDir(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT&& player2_.getSnake().getDir() != Direction.LEFT) {
				player2_.changeDir(Direction.RIGHT);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN&& player2_.getSnake().getDir() != Direction.UP) {
				player2_.changeDir(Direction.DOWN);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT&& player2_.getSnake().getDir() != Direction.RIGHT) {
				player2_.changeDir(Direction.LEFT);
			}
		}
		if (player1_.isHuman()) {
			if (e.getKeyCode() == KeyEvent.VK_A && player1_.getSnake().getDir() != Direction.RIGHT) {
				player1_.changeDir(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_S && player1_.getSnake().getDir() != Direction.UP) {
				player1_.changeDir(Direction.DOWN);
			}
			if (e.getKeyCode() == KeyEvent.VK_D && player1_.getSnake().getDir() != Direction.LEFT) {
				player1_.changeDir(Direction.RIGHT);
			}
			if (e.getKeyCode() == KeyEvent.VK_W && player1_.getSnake().getDir() != Direction.DOWN) {
				player1_.changeDir(Direction.UP);
			}
		}
	}
	//accessor
	public boolean isGameOver(){
		return isGameOver_;
	}
	
}