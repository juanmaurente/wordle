import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	String wordToGuess;
	String userWord;
	boolean hasWon;
	int guessRemaining;

	public Game() throws FileNotFoundException {
		this.guessRemaining = 6;
		this.hasWon = false;
		this.wordToGuess = createRandomWord();
	}

	public int getGuessRemaining() {
		return guessRemaining;
	}

	public void setGuessRemaining(int guessRemaining) {
		this.guessRemaining = guessRemaining;
	}

	public String getWordToGuess() {
		return wordToGuess;
	}

	public void setWordToGuess(String wordToGuess) throws FileNotFoundException {
		this.wordToGuess = createRandomWord();
	}

	public String getUserWord() {
		return userWord;
	}

	public void setUserWord(String userWord) {
		this.userWord = userWord;
	}

	public static List<String> importVocabulary() throws FileNotFoundException {
		List<String> vocabulary = new ArrayList<String>();
		File file = new File("word-list.json");
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String line = input.nextLine().replace(",", "").replace("[", "").replace("]", "").replace("\"", "");
			vocabulary.add(line);
		}
		input.close();
		return vocabulary;
	}

	public String createRandomWord() throws FileNotFoundException {
		List<String> vocabulary = importVocabulary();
		String word = vocabulary.get((int) (Math.random() * vocabulary.size()));
		return word;
	}

	public void reduceGuessRemaining(int guessRemaining) {
		this.guessRemaining = guessRemaining -1;
	}
}
