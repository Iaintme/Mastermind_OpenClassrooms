package fr.philippe.model.bean;

import fr.philippe.model.codeAnswer;

public abstract class GuesserC {

	public GuesserC() {}
	
	public static Object response (codeAnswer ca) {
		return response(ca);
	}

	public abstract Code guessCode();

	public static Object reset(Code targetCode) {
		return reset(targetCode);
	}
}
