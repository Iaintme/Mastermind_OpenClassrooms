package fr.philippe.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class config {

	private static int colorC = 4;
	private static int turn = 12;
	private static int codeLength = 4;
	
	public static void main(String[] args) {
		Properties properties = new Properties();
		InputStream in = null;

		try {
			in = new FileInputStream("config.properties");
			properties.load(in);
			
			colorC = Integer.parseInt(properties.getProperty("colorC", "4"));
			turn = Integer.parseInt(properties.getProperty("turn"));
			codeLength = Integer.parseInt(properties.getProperty("codeLength"));
			
			if (codeLength > 10 && codeLength < 4) codeLength = 8;
			for (int codeLength = 4; codeLength<10; codeLength++)
			{
				if (codeLength <= 4 && codeLength >= 5)
				{
					turn = 12;
					System.out.println("Vous avez choisi le level aesy, vous avez " + turn + "chances de réussite");
				}
				else if (codeLength>=6 && codeLength<= 7)
				{
					turn = 20;
					System.out.println("Vous avez choisi le level normal, vous avez " + turn + "chances de réussite");
				}
				else if (codeLength <= 8 && codeLength >= 10)
				{
					turn = 30;
					System.out.println("Vous avez choisi le level difficile, vous avez " + turn + "chances de réussite");
				}
				else if(codeLength == 10)
				{
					turn = 25;
					System.out.println("Vous avez choisi le level challenger, vous avez " + turn + "chances de réussite");
				}
			}
		}
		catch (IOException | NumberFormatException error) {
			error.printStackTrace();
			System.out.println("Erreur!");			
		}
		finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("colorC : " + colorC);
		System.out.println("turn : " + turn);
		System.out.println("codeLength : " + codeLength);
	}

	/**
	 * @return the colorC
	 */
	public static int getColorC() {
		return colorC;
	}

	/**
	 * @param colorC the colorC to set
	 */
	public static void setColorC(int colorC) {
		config.colorC = colorC;
	}

	/**
	 * @return the turn
	 */
	public static int getTurn() {
		return turn;
	}

	/**
	 * @param turn the turn to set
	 */
	public static void setTurn(int turn) {
		config.turn = turn;
	}

	/**
	 * @return the codeLength
	 */
	public static int getCodeLength() {
		return codeLength;
	}

	/**
	 * @param codeLength the codeLength to set
	 */
	public static void setCodeLength(int codeLength) {
		config.codeLength = codeLength;
	}
}
