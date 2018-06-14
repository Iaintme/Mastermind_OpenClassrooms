package fr.philippe.model.bean;

import fr.philippe.model.codeAnswer;

public abstract class Generator {
	
	protected Code targetCode() {
		/*
		 * Compare code with targetcode
		 * @param c the code to compare with the target code
		 * @return the result of the comparaison		
		 */
		return targetCode();
	}
	
	public codeAnswer compareToTarget(Code c) 
	{
		return compareToTarget(c);
	}
	
	public Object setTargetCode (Code newTargetCode) 
	{
		return setTargetCode(newTargetCode);
	}
	
	public abstract void generateTargetCode();
}
