package app;

import java.util.Arrays;

import app.utils.Const;

public class SnakeBuilder {

	public SnakeBuilder() {

	}

	public int[][] getDefaultSnake() {
		int[][] snake = new int[5][2];

		snake[0][0] = 3;
		snake[0][1] = 4;

		snake[1][0] = 3;
		snake[1][1] = 5;

		snake[2][0] = 3;
		snake[2][1] = 6;

		snake[3][0] = 3;
		snake[3][1] = 7;

		snake[4][0] = -1;
		snake[4][1] = -1;

		System.out.println("snake=" + Arrays.deepToString(snake));
		return snake;
	}

	public int[][] buildSnake(int[][] snake, @Const.Direction int inputDirection) {
		int[][] newSnake = new int[snake.length][2];
		int direction = getDirection(snake, inputDirection);
		for (int i = 0; i < snake.length; i++) {
			int finalRow = -1;
			int finalCol = -1;
			if (i == 0) {
				// Snake head
				int snakeRow = snake[i][0];
				int snakeCol = snake[i][1];
				if (direction == Const.Direction.LEFT) {
					finalRow = snakeRow;
					finalCol = --snakeCol;
				} else if (direction == Const.Direction.RIGHT) {
					finalRow = snakeRow;
					finalCol = ++snakeCol;
				} else if (direction == Const.Direction.UP) {
					finalRow = --snakeRow;
					finalCol = snakeCol;
				} else if (direction == Const.Direction.DOWN) {
					finalRow = ++snakeRow;
					finalCol = snakeCol;
				}
			} else {
				// Snake body
				// System.out.println("snake" + i + "-1.0:" + snake[i-1][0] + ", snake" + i +
				// "-1.1:" + snake[i-1][1]);
				if (snake[i][0] == -1) {
					// Snake ended
					System.out.println("Snake ended");
					finalRow = -1;
					finalCol = -1;
				} else {
					finalRow = snake[i - 1][0];
					finalCol = snake[i - 1][1];
				}
			}
			System.out.println("snake" + i + "0=" + snake[i][0] + ";finalRow=" + finalRow
					+ ",    snake" + i + "1=" + snake[i][1] + ";finalCol=" + finalCol);
			newSnake[i][0] = finalRow;
			newSnake[i][1] = finalCol;
			
		}
		System.out.println("newSnake=" + Arrays.deepToString(newSnake));
		return newSnake;
	}

	private int getInputDirectionUpdated(int currentDirection, int inputDirection) {
		int inputDirectionUpdated = inputDirection;
		if (currentDirection == Const.Direction.LEFT && inputDirection == Const.Direction.RIGHT
				|| currentDirection == Const.Direction.RIGHT && inputDirection == Const.Direction.LEFT
				|| currentDirection == Const.Direction.UP && inputDirection == Const.Direction.DOWN
				|| currentDirection == Const.Direction.DOWN && inputDirection == Const.Direction.UP
				|| (inputDirection != Const.Direction.DOWN && inputDirection != Const.Direction.UP
						&& inputDirection != Const.Direction.RIGHT && inputDirection != Const.Direction.LEFT)) {
			inputDirectionUpdated = currentDirection;
		}
		return inputDirectionUpdated;
	}

	private int getDirection(int[][] snake, int inputDirection) {
		int direction = -1;
		int cell1 = 0;
		int cell2 = 1;
		if (snake[cell1][0] == snake[cell2][0]) {
			// Snake is moving horizontally
			System.out.print("Direction: Horizontal ");
			if (snake[cell1][1] < snake[cell2][1]) {
				// Snake is moving left
				System.out.println("Left");
				direction = Const.Direction.LEFT;
			} else {
				// Snake is moving right
				System.out.println("Right");
				direction = Const.Direction.RIGHT;
			}
		} else if (snake[cell1][1] == snake[cell2][1]) {
			// Snake is moving vertically
			System.out.print("Direction: Vertical ");
			if (snake[cell1][0] < snake[cell2][0]) {
				// Snake is moving up
				System.out.println("Up");
				direction = Const.Direction.UP;
			} else {
				// Snake is moving down
				System.out.println("Down");
				direction = Const.Direction.DOWN;
			}
		}
		return getInputDirectionUpdated(direction, inputDirection);
	}

}
