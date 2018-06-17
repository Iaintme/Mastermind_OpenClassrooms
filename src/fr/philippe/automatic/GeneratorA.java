package fr.philippe.automatic;

import java.util.concurrent.ThreadLocalRandom;

import fr.philippe.model.Color;
import fr.philippe.properties.config;

public class GeneratorA {

	
	public void generateTargetCode() 
	{
		Color[] colors = new Color[config.getCodeLength()];
		for (int i = 0; i < config.getCodeLength(); i++)
		{
			colors[i] = Color.values()[ThreadLocalRandom.current().nextInt()];
		}
//		targetCode = new Code(colors);
	}
}
