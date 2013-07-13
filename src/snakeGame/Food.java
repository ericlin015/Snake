package snakeGame;

public class Food {
	private int foodX_;
	private int foodY_;
	
	public Food(Snake snake1, Snake snake2){
		makeNewFood(snake1, snake2);
	}
	
	public void makeNewFood(Snake snake1, Snake snake2){
		foodX_= ((int) (Math.random() * 128) + 1) * 5;
        foodY_ = ((int) (Math.random() * 64) + 1) * 5;
        while (isOnSnake(snake1,snake2)) {
            foodX_ = ((int) (Math.random() * 128) + 1) * 5;
            foodY_ = ((int) (Math.random() * 64) + 1) * 5;
        }
	}
	
	public boolean isOnSnake(Snake snake1, Snake snake2){
	    int []snake1X = snake1.getSnakeX();
	    int []snake1Y = snake1.getSnakeY();
	    int []snake2X = snake2.getSnakeX();
	    int []snake2Y = snake2.getSnakeY();
		for(int i =0;i<snake1.getLength();i++){
			if(foodX_ == snake1X[i] ){
				return false;
			}
			if(foodY_ == snake1Y[i]){
				return false;
			}
		}//for faster performance we check two snakes at once
		for(int i =0;i<snake2.getLength();i++){
			if(foodX_ == snake2X[i]){
				return false;
			}
			if(foodY_ == snake2Y[i]){
				return false;
			}
		}
		return true;
	}
	
	public int getFoodX(){
		return foodX_;
	}
	public int getFoodY(){
		return foodY_;
	}
}
