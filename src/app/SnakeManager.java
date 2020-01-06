package app;

import java.util.concurrent.ThreadLocalRandom;

import app.input.IInputCallback;
import app.input.InputManager;
import app.utils.Const;

public class SnakeManager implements IInputCallback {

	private DisplayManager mDisplayManager;

	private InputManager mInputManager;

	private SnakeBuilder mSnakeBuilder;

	private int[][] mSnake;

	private boolean mIsInputActive;

	private int mFoodRow = -1;

	private int mFoodCol = -1;

	public static boolean didSnakeEatFood = false;

	public SnakeManager() {
		mDisplayManager = new DisplayManager();
		mInputManager = new InputManager(this);
		mSnakeBuilder = new SnakeBuilder();
	}

	public void init() {
		mSnake = mSnakeBuilder.getDefaultSnake();
		updateFood();

		mDisplayManager.drawGrid(mSnake, mFoodRow, mFoodCol);
		mIsInputActive = true;

		mInputManager.listenForInput();
	}

	@Override
	public void onInput(int inputType) {
		System.out.println("inputType: " + inputType);
		if (mIsInputActive) {
			mSnake = mSnakeBuilder.buildSnake(mSnake, inputType);
			if (didSnakeEatFood()) {
				// Snake ate food.
				System.out.println("Snake ate food");
				didSnakeEatFood = true;
				updateFood();
			} else {
				// Snake did not eat food.
			}
			if (mSnake != null) {
				// Snake is active inside box.
				mDisplayManager.drawGrid(mSnake, mFoodRow, mFoodCol);
			} else {
				// Snake hit box. Game over.
				System.out.println("\n\nGame over!!!");
				mIsInputActive = false;
			}
		} else {
			// Input inactive
			System.out.println("Input is inactive!!");
		}
	}

	private void updateFood() {
		mFoodRow = ThreadLocalRandom.current().nextInt(0, Const.ROW_MAX - 1);
		mFoodCol = ThreadLocalRandom.current().nextInt(0, Const.COL_MAX - 1);
	}

	private boolean didSnakeEatFood() {
		boolean didSnakeEatFood = false;
		if (mSnake != null) {
			for (int i = 0; i < mSnake.length; i++) {
				if (mSnake[i][0] == mFoodRow && mSnake[i][1] == mFoodCol) {
					didSnakeEatFood = true;
					break;
				}
			}
		} else {
			// Snake is null
		}
		return didSnakeEatFood;
	}

}
