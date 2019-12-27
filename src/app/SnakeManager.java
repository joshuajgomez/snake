package app;

import app.input.IInputCallback;
import app.input.InputManager;

public class SnakeManager implements IInputCallback {

	private DisplayManager mDisplayManager;

	private InputManager mInputManager;

	private SnakeBuilder mSnakeBuilder;

	private int[][] mSnake;

	private boolean mIsInputActive;

	public SnakeManager() {
		mDisplayManager = new DisplayManager();
		mInputManager = new InputManager(this);
		mSnakeBuilder = new SnakeBuilder();
	}

	public void init() {
		mSnake = mSnakeBuilder.getDefaultSnake();
		mDisplayManager.drawGrid(mSnake);
		mIsInputActive = true;
		mInputManager.listenForInput();
	}

	@Override
	public void onInput(int inputType) {
		System.out.println("inputType: " + inputType);
		if (mIsInputActive) {
			mSnake = mSnakeBuilder.buildSnake(mSnake, inputType);
			if (mSnake != null) {
				mDisplayManager.drawGrid(mSnake);
			} else {
				System.out.println("\n\nGame over!!!");
				mIsInputActive = false;
			}
		} else {
			// Input inactive
			System.out.println("Input is inactive!!");
		}
	}

}
