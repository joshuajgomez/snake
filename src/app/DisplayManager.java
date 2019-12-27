package app;

import app.utils.Const;
import app.utils.Logger;

public class DisplayManager {

	private static final String ROW_SPACE = " ";

	private static final String SNAKE_BODY = "##";

	private static final String SNAKE_HEAD = "@@";

	public void drawGrid(int[][] snake) {
		for (int row = 0; row < Const.ROW_MAX; row++) {
			for (int col = 0; col < Const.COL_MAX; col++) {
				String drawItem = getDrawitem(row, col, snake);
				System.out.print(drawItem + ROW_SPACE);
			}
			System.out.println();
		}
	}

	private String getDrawitem(int row, int col, int[][] snake) {
		String drawItem = "";
		for (int i = 0; i < snake.length; i++) {
			if (row == snake[i][0] && col == snake[i][1]) {
				// Snake present at this cell
				if (i == 0) {
					// Snake body's start = Head.
					drawItem = SNAKE_HEAD;
				} else {
					// Rest of the snake body
					drawItem = SNAKE_BODY;
				}
				break;
			} else {
				// Snake empty here
				drawItem = row + "" + col;
			}
		}
		return drawItem;
	}

}
