package app.input;

import app.utils.Const;

public interface IInputCallback {
	
	void onInput(@Const.Direction int inputType);
	
}
