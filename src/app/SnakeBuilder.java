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
			int newRow = -1;
			int newCol = -1;
			if (i == 0) {
				// Snake head
				int snakeRow = snake[i][0];
				int snakeCol = snake[i][1];
				if (direction == Const.Direction.LEFT) {
					newRow = snakeRow;
					newCol = --snakeCol;
				} else if (direction == Const.Direction.RIGHT) {
					newRow = snakeRow;
					newCol = ++snakeCol;
				} else if (direction == Const.Direction.UP) {
					newRow = --snakeRow;
					newCol = snakeCol;
				} else if (direction == Const.Direction.DOWN) {
					newRow = ++snakeRow;
					newCol = snakeCol;
				}
			} else {
				// Snake body
				if (snake[i][0] == -1) {
					// New snake complete
					newRow = -1;
					newCol = -1;
				} else {
					// New snake not complete. Copy previous cell of snake.
					newRow = snake[i - 1][0];
					newCol = snake[i - 1][1];
				}
			}
			System.out.println("snake" + i + "0=" + snake[i][0] + ";newRow=" + newRow
					+ ",    snake" + i + "1=" + snake[i][1] + ";newCol=" + newCol);
			newSnake[i][0] = newRow;
			newSnake[i][1] = newCol;
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
