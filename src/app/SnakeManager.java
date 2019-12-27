package app;

import app.input.IInputCallback;
import app.input.InputManager;

public class SnakeManager implements IInputCallback {

	private DisplayManager mDisplayManager;
	
	private InputManager mInputManager;
	
	private SnakeBuilder mSnakeBuilder;
	
	private int[][] mSnake;
	
	public SnakeManager() {
		mDisplayManager = new DisplayManager();
		mInputManager = new InputManager(this);
		mSnakeBuilder = new SnakeBuilder();
	}
	
	public void init() {
		mSnake = mSnakeBuilder.getDefaultSnake();
		mDisplayManager.drawGrid(mSnake);
		mInputManager.listenForInput();
	}

	@Override
	public void onInput(int inputType) {
		System.out.println("inputType: " + inputType);
		mSnake = mSnakeBuilder.buildSnake(mSnake, inputType);
		mDisplayManager.drawGrid(mSnake);
	}
	
	
	
}
