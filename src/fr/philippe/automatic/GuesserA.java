package fr.philippe.automatic;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import fr.philippe.model.Color;
import fr.philippe.model.codeAnswer;
import fr.philippe.model.bean.Code;
import fr.philippe.properties.config;

public class GuesserA {

	private ArrayList<Code> possibleCode;
	private Code lastCode;
	private Color colors;
	
	public GuesserA(ArrayList<Code> possibleCode) {
		this.possibleCode = possibleCode;
	}
	
	public void reset()
	{
		lastCode = null;
		possibleCode.clear();
		generateCode(config.getCodeLength());
	}
	
	public ArrayList<Code> generateCode (int length)
	{
		generateCode(new ArrayList<Color>(), length);
		return possibleCode;
	}
	
	public void generateCode(ArrayList<Color> colors, int depth)
	{
		if (depth == 0)
		{
			possibleCode.add(new Code(colors.toArray(new Color[0])));
		}
		else
		{
			for(Color c : Color.values())
			{
				colors.add(c);
				generateCode(colors, depth-1);
				colors.remove(size()-1);
			}
		}
	}
	
	private int size() {
		return 0;
	}

	public Code guessCode()
	{
		if (lastCode == null)
		{
			lastCode = new Code(colors);
		}
		else
		{
			lastCode = possibleCode.get(ThreadLocalRandom.current().nextInt(0, possibleCode.size()));
		}
		return lastCode;
	}
	
	public void response (codeAnswer answer)
	{
		possibleCode.removeIf(c->!c.compareCode(lastCode).equals(answer));
	}
}
