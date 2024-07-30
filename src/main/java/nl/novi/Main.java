package nl.novi;

import nl.novi.hangman.Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

//    Scanner namesFromFile = new Scanner(new File("./src/main/java/nl/novi/names"));
    var file = new File("./src/main/java/nl/novi/names");
    Scanner inputScanner = new Scanner(System.in);
    Hangman hangman = new Hangman(inputScanner, file);
    hangman.playGame();

//    String helloWorld = "Hello world";
//    var output = helloWorld.split("d").length - 1;
//    if(helloWorld.endsWith("d")) {
//      output++;
//    }
//    System.out.println(output);

//
//
//    List<String> words = new ArrayList<>();
//    List<Character> guessedLetters = new ArrayList<>();
//    Random random = new Random();
//
//
//    while (namesFromFile.hasNext()) {
//      words.add(namesFromFile.nextLine());
//    }
//    String selectedWord = words.get(random.nextInt(words.size())).toLowerCase();
//    System.out.println(selectedWord);
//    printOutResult(selectedWord, guessedLetters);
//
//    while (true) {
//      getPlayerGuesses(inputScanner, selectedWord, guessedLetters);
////      if(printOutResult(selectedWord,guessedLetters)) {
////        break;
////      }
//    }
  }

//  private static void getPlayerGuesses(Scanner input,String word, List<Character> lettersGuesed) {
//    System.out.println();
//    System.out.println("Enter a letter");
//    String letter = input.nextLine().toLowerCase();
//    lettersGuesed.add(letter.charAt(0));
//    printOutResult(word, lettersGuesed);
//  }
//
//  private static boolean printOutResult(String word, List<Character> letterGuesed) {
//    int correctCount = 0;
//    for (int i = 0; i < word.length(); i++) {
//      if (letterGuesed.contains(word.charAt(i))) {
//        System.out.print(word.charAt(i));
//        correctCount++;
//      }
//      else {
//        System.out.print(" - ");
//      }
//    }
//    return (word.length() == correctCount);
//  }
}
