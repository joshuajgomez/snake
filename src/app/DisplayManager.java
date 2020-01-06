package app;

import app.utils.Const;
import app.utils.Logger;

public class DisplayManager {

	private static final String ROW_SPACE = " ";

	private static final String SNAKE_BODY = "##";

	private static final String SNAKE_HEAD = "@@";

	private static final String FOOD = "$$";

	private int[][] mSnake;

	private int mFoodRow;

	private int mFoodCol;

	public void drawGrid(int[][] snake, int foodRow, int foodCol) {
		this.mSnake = snake;
		this.mFoodRow = foodRow;
		this.mFoodCol = foodCol;
		for (int row = 0; row < Const.ROW_MAX; row++) {
			for (int col = 0; col < Const.COL_MAX; col++) {
				String drawItem = getDrawitem(row, col);
				System.out.print(drawItem + ROW_SPACE);
			}
			System.out.println();
		}
	}

	private String getDrawitem(int row, int col) {
		String drawItem = "";
		for (int i = 0; i < mSnake.length; i++) {
			if (row == mSnake[i][0] && col == mSnake[i][1]) {
				// Snake present at this cell
				if (i == 0) {
					// Snake body's start = Head.
					drawItem = SNAKE_HEAD;
				} else {
					// Rest of the snake body
					drawItem = SNAKE_BODY;
				}
				break;
			} else if (row == mFoodRow && col == mFoodCol) {
				// Snake food
				drawItem = FOOD;
			} else {
				// Snake empty here
				drawItem = row + "" + col;
			}
		}
		return drawItem;
	}

}
