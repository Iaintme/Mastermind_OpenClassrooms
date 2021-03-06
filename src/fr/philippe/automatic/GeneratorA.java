package fr.philippe.automatic;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import fr.philippe.model.Color;
import fr.philippe.model.bean.Code;
import fr.philippe.model.bean.GeneratorC;
import fr.philippe.properties.config;

public class GeneratorA extends GeneratorC{

	
	public ArrayList<Code> generateTargetCode() 
	{
		Color[] colors = new Color[config.getCodeLength()];
		for (int i = 0; i < config.getCodeLength(); i++)
		{
			colors[i] = Color.values()[ThreadLocalRandom.current().nextInt()];
		}
//		targetCode = new Code(colors);
		return generateTargetCode();
	}
}
