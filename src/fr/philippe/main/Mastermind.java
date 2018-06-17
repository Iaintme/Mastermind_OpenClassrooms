package fr.philippe.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import fr.philippe.automatic.GeneratorA;
import fr.philippe.automatic.GuesserA;
import fr.philippe.human.GeneratorH;
import fr.philippe.human.GuesserH;
import fr.philippe.model.codeAnswer;
import fr.philippe.model.bean.Code;
import fr.philippe.model.bean.GeneratorC;
import fr.philippe.model.bean.GuesserC;
import fr.philippe.properties.config;
import fr.philippe.view.View;

public class Mastermind {

	    public static int maxRounds = 10;
	    public static boolean humanGuesser = false;
	    public static boolean humanGenerator = false;
	    public static boolean manual = false;
	    public static boolean supressOutput = false;
	    public static String helpString =
	    "The Game Mastermind:\n"+
	    "Commandline Options:\n"+
	    "  -g --guesses [guesses]\tSet maximum guesses per game. Default: 10\n"+
	    "  -h --human\t\tLet the user guess the code\n"+
	    "  -c --code\t\tLet the user input the target code\n"+
	    "  -m --manual\t\tThe user has to input everything: Code, guesses and answers\n"+
	    "     --help\t\tShow this help message and exit\n"+
	    "This software is written by Lars Kadel and under no license, do whatever you want with it!";

	    private Code targetCode;

		private View view;		
		private GuesserC guesser;
		private GeneratorC generator;

	  /**
		*
		*/
		public Mastermind(){
	        view = new View();
	        guesser = Mastermind.humanGuesser ? new GuesserH(view) : new GuesserA();
	        generator = Mastermind.humanGenerator ? new GeneratorH(view) : new GeneratorA();
		}

	    /**
		*	Play one round of the game
		*	@return int: The rounds played until the correct code was guessed, -1 if guessed incorrectly
		*/
	    public int playGame(Code targetCode){
	        boolean won = false;
			GuesserC.reset(targetCode);
			if(targetCode == null){
	        	generator.generateTargetCode();
			}else{
				GeneratorC.setTargetCode(targetCode);
			}
	        int round;
			for(round = 0; round < Mastermind.maxRounds && !won; ++round){
	            Code roundCode = guesser.guessCode();
	            codeAnswer answer = GeneratorC.compareToTarget(roundCode);
				GuesserC.response(answer);
	            view.showCodeAnswer(answer, round);
				if(answer.black == config.getCodeLength()){
	                won=true;
	            }
	        }
	        if(won){
	            view.showWin();
				return round+1;
	        }else{
	            view.showLoose();
				return -1;
	        }
	    }

	    public static void main(String... args){
	        interpretArguments(args);
	        Mastermind game = new Mastermind();
	        game.playGame(null);
		}

	    public static void interpretArguments(String... args){
	        Iterator<String> argIterator = Arrays.asList(args).iterator();
	        while(argIterator.hasNext()){
	            String arg = argIterator.next();
	            switch (arg){
	                case "-g":
	                case "--guesses":
	                    Mastermind.maxRounds = Integer.parseInt(argIterator.next());
	                    break;
	                case "-h":
	                case "--human":
	                    Mastermind.humanGuesser = true;
	                    break;
	                case "-c":
	                case "--code":
	                    Mastermind.humanGenerator = true;
	                    break;
	                case "-m":
	                case "--manual":
	                    Mastermind.humanGuesser = true;
	                    Mastermind.humanGenerator = true;
	                    Mastermind.manual = true;
	                    break;
	                case "--help":
	                    System.out.println(helpString);
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Didn't recognise the Argument '"+arg+"'\nUse the --help option for help");
	            }
	        }
	    }

	    public static void testSuit(){
	        Mastermind game = new Mastermind();
	        GuesserA ag = new GuesserA(null);
			ArrayList<Code> allCodes = ag.generateCode(config.getCodeLength());
			int gamesPlayed = 0;
			int totalGuesses = 0;
			int mostRounds = 0;
			Code longestCode = null;
			for(Code c : allCodes){
				gamesPlayed++;
				int roundsPlayed = game.playGame(c);
	            if(roundsPlayed == -1){
	                System.out.println("Couldn't guess code!");
	            }
				totalGuesses += roundsPlayed;
				if(roundsPlayed > mostRounds){
					mostRounds = roundsPlayed;
					longestCode = c;
				}
			}
			System.out.println("Max guesses: " + mostRounds + " with code "+ longestCode);
			System.out.println("Total Guesses: " + totalGuesses + "In "+ gamesPlayed + " rounds. Average: " + ((float) totalGuesses/gamesPlayed));
	    }

		public Code getTargetCode() {
			return targetCode;
		}

		public void setTargetCode(Code targetCode) {
			this.targetCode = targetCode;
		}
	}
