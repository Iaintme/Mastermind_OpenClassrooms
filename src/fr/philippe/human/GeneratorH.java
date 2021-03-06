package fr.philippe.human;

import java.util.ArrayList;

import fr.philippe.model.Color;
import fr.philippe.model.bean.Code;
import fr.philippe.model.bean.GeneratorC;
import fr.philippe.properties.config;
import fr.philippe.view.View;

public class GeneratorH extends GeneratorC{

	private View view;
	private Color colors;
	
	public GeneratorH (View v)
	{
		this.view = v;
	}
	
	public ArrayList<Code> generateTargetCode()
	{
		Color[] colors = new Color[config.getCodeLength()];
		System.out.println("Set the code to be guessed");
		
		for (int i = 0; i < config.getCodeLength(); i++)
		{
			colors[i] =  view.waitColor(i);
		}
		Code targetCode = new Code(colors);
		System.out.println("\033[H\033[2J");
		return generateTargetCode();
	}

}
