package fr.philippe.human;

import fr.philippe.model.Color;
import fr.philippe.model.bean.Code;
import fr.philippe.properties.config;
import fr.philippe.view.View;

public class Guesser {
	
	private View view;
	private Color colors;

	public Guesser(View view) {
		this.view = view;
	}
	
	public Code guessCode() {
		Color [] colors = new Color[config.getCodeLength()];
		
		for (int i =0; i < config.getCodeLength(); i++)
		{
			colors[i] = view.waitColor(i);
		}
		
		System.out.println("you enter code : ");
		for (Color c : colors)
		{
			System.out.println(c.name()+" ");
		}
		System.out.println("\n");
		return new Code(colors);
	}
}
