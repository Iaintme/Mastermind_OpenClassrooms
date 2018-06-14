package fr.philippe.model;

public class codeAnswer {
	
	public int black;
	public int white;

	public codeAnswer(int black, int white) {
		this.black = black;
		this.white = white;
	}
	
	public boolean equals (codeAnswer c) {
		return c.black == this.black && c.white == this.white;
	}
}
