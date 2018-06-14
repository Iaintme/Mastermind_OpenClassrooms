package fr.philippe.view;

import java.util.Scanner;

import fr.philippe.model.Color;
import fr.philippe.model.codeAnswer;
import fr.philippe.model.bean.Code;

public class View {
	private Scanner sc;
	private Color colors;
	
	public View()
	{
		sc = new Scanner(System.in);
	}
	
	public void showTargetCode (Code targetCode) {
		System.out.println(targetCode.toString());
	}
	
	public void showCodeAnswer (codeAnswer answer, int round)
	{
		System.out.println("Black : " +answer.black+ " White : " +answer.white);
	}
	
	public void showLoose()
	{
		System.out.println("You have to train, you lost !");
	}
	
	public void showWin()
	{
		System.out.println("You win! You can try a new level !");
	}

	public Color waitColor(int i) {
		System.out.println("Give me a color for position " + i + colors);
		return null;
	}
}
