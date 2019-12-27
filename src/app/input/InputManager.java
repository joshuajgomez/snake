package app.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import app.utils.Const;

public class InputManager {

	private IInputCallback mCallback;
	
	public InputManager (IInputCallback callback) {
		mCallback = callback;
	}
	
	public void listenForInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			do {
				System.out.println("Listening for input: ");
				String inputKey = br.readLine();
				int input = -1;
				if (inputKey.equalsIgnoreCase("w")) {
					input = Const.Direction.UP;
				} else if (inputKey.equalsIgnoreCase("a")) {
					input = Const.Direction.LEFT;
				}  else if (inputKey.equalsIgnoreCase("s")) {
					input = Const.Direction.DOWN;
				} else if (inputKey.equalsIgnoreCase("d")) {
					input = Const.Direction.RIGHT;
				} 
				mCallback.onInput(input);
			} while (true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
