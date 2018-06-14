package fr.philippe.dev;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import fr.philippe.properties.config;

public class Test {

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
}



/*
 * easy.codeLength = 4
easy.turn = 12

normal.codeLength = 5
normal.turn = 20

difficil.codeLength = 6
difficil.turn = 30

hard.codeLength = 6
hard.turn = 30
hard.color = (5+1)
 */
