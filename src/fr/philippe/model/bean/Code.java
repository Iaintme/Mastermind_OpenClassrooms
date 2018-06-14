package fr.philippe.model.bean;

import fr.philippe.model.Color;
import fr.philippe.model.codeAnswer;
import fr.philippe.properties.config;

public class Code {

	private Color [] code;
	
	public Code (Color... c) {
		if (c.length != config.getCodeLength()) {
			throw new IllegalArgumentException("Worng argument count for Code");
		}
		this.code = c;
	}
	
	public Color [] getCodeArray() {
		return code.clone();
	}
	
	public codeAnswer compareCode(Code c) 
	{
		Color [] thisCode = getCodeArray();
		Color [] oCode = c.getCodeArray();
		int black = 0;
		for (int i = 0; i < config.getCodeLength(); i++)
		{
			if (thisCode[i] == oCode[i])
			{
				black++;
				thisCode[i] = null;
				oCode[i] = null;
			}
		}
		int white = 0;
		for (int i = 0; i < config.getCodeLength(); i++)
		{
			for (int j =0; j< config.getCodeLength(); j++)
			{
				if (thisCode[i]== oCode[j] && thisCode[i] != null)
				{
					white++;
					thisCode[i] = null;
					oCode[j] = null;
				}
			}
		}
		return new codeAnswer(black, white);
	}
	
	public int targetCode()
	{
		int ta = 0;
		return ta;
	}
	
	public String toString()
	{
		String str = "";
		for(Color c : code)
		{
			str += c.name()+" ";
		}		return str;
	}
}
