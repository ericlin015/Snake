package snakeGame;

public class Snake {
	private int length_;
	private int[] mySnakeX_;
	private int[] mySnakeY_;
	private int playerNum_;
	
	public void Snake(int player){
		mySnakeX_ = new int[650];
		mySnakeY_ = new int[330];
		playerNum_ = player;
		length_ = 7;
		if(playerNum_ == 1){
			for (int i = 0; i<7; i++) {
	            mySnakeX_[i] = 100 - i * 5;
	            mySnakeY_[i] = 100;
	        }
		}else{
			for (int i = 0; i<7; i++) {
	            mySnakeX_[i] = 550 + i * 5;
	            mySnakeY_[i] = 100;
	        }
		}
	}
	
	public void snakeGrow(Food food){
		mySnakeX_[length_] = food.getFoodX();
		mySnakeY_[length_] = food.getFoodY();
		length_++;
	}
	
	//bunch of accessors
	public int getLength(){
		return length_;
	}
	
	public int getplayerNum(){
		return playerNum_;
	}
	
	public int[] getSnakeX(){
		return mySnakeX_;
	}
	
	public int[] getSnakeY(){
		return mySnakeY_;
	}
	
}
