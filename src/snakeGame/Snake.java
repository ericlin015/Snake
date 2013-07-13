package snakeGame;

public class Snake {
	private int length_;
	private int[] mySnakeX_;
	private int[] mySnakeY_;
	private Direction dir_;
	private int[] headAndTail = new int[4]; // this array gives 4 values, head X and Y, tail X and Y from 0 to 3
	
	public enum Direction{
		UP,DOWN,LEFT,RIGHT
	}
	
	public Snake(int player){
		mySnakeX_ = new int[650];
		mySnakeY_ = new int[330];
		length_ = 7;
		if(player == 1){
			for (int i = 0; i<7; i++) {
	            mySnakeX_[i] = 100 - i * 5;
	            mySnakeY_[i] = 100;
	        }
			dir_ = Direction.RIGHT;
		}else{
			for (int i = 0; i<7; i++) {
	            mySnakeX_[i] = 550 + i * 5;
	            mySnakeY_[i] = 100;
	        }
			dir_ = Direction.LEFT;
		}
		headAndTail[0] = mySnakeX_[0];
		headAndTail[1] = mySnakeY_[0];
		headAndTail[2] = mySnakeX_[length_-1];
		headAndTail[3] = mySnakeY_[length_-1];
	}
	
	public void changeDir(Direction dir){
		dir_ = dir;
	}
	
	public void snakeGrow(Food food){
		headAndTail[0] = mySnakeX_[0];
		headAndTail[1] = mySnakeY_[0];
		mySnakeX_[length_] = food.getFoodX();
		mySnakeY_[length_] = food.getFoodY();
		length_++;
	}
	
	public void snakeMove(){
		headAndTail[2] = mySnakeX_[length_-1];
		headAndTail[3] = mySnakeY_[length_-1];
		for(int i=length_-1;i>0;i--){
			mySnakeY_[i] =mySnakeY_[i-1];
			mySnakeX_[i] =mySnakeX_[i-1];
		}
		if(dir_ == Direction.DOWN){
			mySnakeY_[0] += 5;
		}else if(dir_ == Direction.UP){
			mySnakeY_[0] -= 5;
		}else if(dir_ == Direction.LEFT){
			mySnakeX_[0] -= 5;
		}else if(dir_ == Direction.RIGHT){
			mySnakeX_[0] += 5;
		}	
		headAndTail[0] = mySnakeX_[0];
		headAndTail[1] = mySnakeY_[0];
	}
	
	//bunch of accessors
	public int[] getHeadAndTail(){
		return headAndTail;
	}
	
	public Direction getDir(){
		return dir_;
	}
	
	public int getLength(){
		return length_;
	}
	
	
	public int[] getSnakeX(){
		return mySnakeX_;
	}
	
	public int[] getSnakeY(){
		return mySnakeY_;
	}
	
}
