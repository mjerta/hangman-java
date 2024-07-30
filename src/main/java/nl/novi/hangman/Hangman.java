package nl.novi.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
  private final List<String> randomWords;
  private List<Character> guessedLetters;
  private final Scanner inputScanner;
  Random random;

  private final Scanner namesFromFile;
  private String selectedWord;

  private boolean gameIsFinished;
  private int trueGuesses;
  private int falseGuesses;
  private boolean hasWon;
  private boolean hasLost;

  public Hangman(Scanner inputScanner, File file) throws FileNotFoundException {
    randomWords = new ArrayList<String>();
    guessedLetters = new ArrayList<>();
    this.inputScanner = inputScanner;
    random = new Random();
    this.namesFromFile = new Scanner(file);
  }

  public void playGame() {
    printoutIntro();
    createRandomWords();
    resetGame();

    while (!gameIsFinished) {
      runRound();
    }
  }

  private void printoutIntro() {
    System.out.println("Welcome to Hangman!\n");
  }

  private void runRound() {
//    System.out.println(selectedWord);
    validateGuess(addGuess());
    printOutResultLetters();
    visualizeHangman();
    handleWinOrLose();
  }

  private void chooseToPlayAgain() {
    while (true) {
      System.out.println("Do you want to play again? (y/n)");
      String answer = inputScanner.nextLine();
      if (answer.equals("y")) {
        resetGame();
        return;
      }
      else if (answer.equals("n")) {
        return;
      }
    }
  }

  private void resetGame() {
    gameIsFinished = false;
    trueGuesses = 0;
    falseGuesses = 0;
    hasWon = false;
    hasLost = false;
    guessedLetters = new ArrayList<>();
    createRandomWordFromList();
  }

  public void createRandomWords() {
    while (namesFromFile.hasNext()) {
      randomWords.add(namesFromFile.nextLine());
    }
  }

  public void createRandomWordFromList() {
    selectedWord = randomWords.get(random.nextInt(randomWords.size())).toLowerCase();
  }

  private String addGuess() {
    System.out.println("Enter a letter");
    // This will make sure only the first letter is being used, even a word is being entered
    return inputScanner.nextLine().toLowerCase();
  }

  private void validateGuess(String letter) {
    if (letter.isEmpty()) {
      System.out.println("Fill in at least one letter");
    }
    else if (selectedWord.contains(letter)) {
      handleRightInput(letter);
    }
    else {
      falseGuesses++;
      handleWrongInput();
    }
  }

  private void handleRightInput(String letter) {

    if (!guessedLetters.isEmpty() && guessedLetters.contains(letter.charAt(0))) {
      System.out.println("You already guessed this letter");
    }
    else {
      System.out.println("You guessed a correct letter");
      trueGuesses += selectedWord.split(letter).length - 1;
      if(selectedWord.endsWith(letter)) {
        trueGuesses++;
      }
      guessedLetters.add(letter.charAt(0));

      if (trueGuesses == selectedWord.length()) {
        hasWon = true;
      }
    }
  }

  private void handleWinOrLose() {
    if (hasWon || hasLost) {
      if (hasWon) {
        System.out.println("You won");
      }
      else {
        System.out.println("You lost buddy, the word should have been " + selectedWord);
      }
      gameIsFinished = true;
      chooseToPlayAgain();
    }
  }

  private void handleWrongInput() {
    if (falseGuesses == 6) {
      hasLost = true;
    }
    else {
      System.out.println("wrong guess");
    }
  }

  private void printOutResultLetters() {
    for (int i = 0; i < selectedWord.length(); i++) {
      if (guessedLetters.contains(selectedWord.charAt(i))) {
        System.out.print(selectedWord.charAt(i));
      }
      else {
        System.out.print("_ ");
      }
    }
    System.out.print("\n");
  }

  private void visualizeHangman() {
    switch (falseGuesses) {
      case 1:
        System.out.println("  o");
        break;
      case 2:
        System.out.println("  o");
        System.out.println("  |");
        break;
      case 3:
        System.out.println(" o");
        System.out.println("/|");
        break;
      case 4:
        System.out.println(" o");
        System.out.println("/|\\");
        break;
      case 5:
        System.out.println(" o");
        System.out.println("/|\\");
        System.out.println("/");
        break;
      case 6:
        System.out.println(" o");
        System.out.println("/|\\");
        System.out.println("/ \\");
        break;
    }
  }
}
