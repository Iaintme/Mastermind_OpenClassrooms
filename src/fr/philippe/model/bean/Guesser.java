package fr.philippe.model.bean;

import fr.philippe.model.codeAnswer;

public abstract class Guesser {

	public Guesser() {}
	
	public void response (codeAnswer ca) {
		
	}

	public abstract Code guessCode();
}
