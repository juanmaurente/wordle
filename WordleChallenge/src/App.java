import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println(String.format("Welcome. Type Y to start a NEW GAME or N to Exit"));
		String startGame = sc.nextLine();

		if (startGame.toUpperCase().equals("N")) {
			System.exit(1);
		} else if (!(startGame.toUpperCase().equals("Y")))
			System.out.println("Please Type Y to start a NEW GAME or N to Exit");
		else {
			Game game = new Game();
			System.out.println("Great! Let the game begin. You have 6 tries to find the word.\n"
					+ "For any correct letter you will see a \"Correct\", if its present \"Present\" or if its not present \"Wrong\""
					+ "\n\n--------------------------------" + "\n\nType a 5 letter word");

			game.createRandomWord();
			game.setUserWord("");

			while (!game.getUserWord().equals(game.getWordToGuess()) && game.getGuessRemaining() > 0) {
				System.out.println("\nYou have "+ game.getGuessRemaining() + " guesses remining");
				game.setUserWord(sc.nextLine().toLowerCase());
				
				if (game.getUserWord().length() != 5) {
					System.out.println("You must type 5 letters");
					continue;
				}

				for (int i = 0; i < game.getWordToGuess().length(); i++) {
					boolean breakOutter = false;
					for (int j = 0; j < game.getWordToGuess().length(); j++) {
						if (game.getUserWord().charAt(i) == game.getWordToGuess().charAt(i)) {
							System.out.print(" Correct ");
							breakOutter = true;
							break;
						}

						if (game.getUserWord().charAt(i) == game.getWordToGuess().charAt(j)) {
							System.out.print(" Present ");
							breakOutter = true;
							break;
						}
					}

					if (!breakOutter) {
						System.out.print(" Wrong ");
					}

				}
				game.reduceGuessRemaining(game.getGuessRemaining());
			}
			if (game.getUserWord().equals(game.getWordToGuess())) {
				System.out.println("\nYOU WIN!!!");

			} else {
				System.out.println(" \n YOU LOOSE. The word was" + game.getWordToGuess());
			}
		}
	}
}
