import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {

    List<String> words = new ArrayList<>();
    List<Character> lettersGuesed = new ArrayList<>();

    Random random = new Random();

    Scanner scanner = new Scanner(new File("./src/main/java/names"));
    Scanner input = new Scanner(System.in);

    while (scanner.hasNext()) {
      words.add(scanner.nextLine());
    }

    String word = words.get(random.nextInt(words.size())).toLowerCase();

    System.out.println(word);


    printOutResult(word, lettersGuesed);

    while (true) {
      getPlayerGuesses(input, word, lettersGuesed);

//      if(printOutResult(word,lettersGuesed)) {
//        break;
//      }
    }
  }

  private static void getPlayerGuesses(Scanner input,String word, List<Character> lettersGuesed) {
    System.out.println();
    System.out.println("Enter a letter");
    String letter = input.nextLine().toLowerCase();
    lettersGuesed.add(letter.charAt(0));
    printOutResult(word, lettersGuesed);
  }

  private static boolean printOutResult(String word, List<Character> letterGuesed) {
    int correctCount = 0;
    for (int i = 0; i < word.length(); i++) {
      if (letterGuesed.contains(word.charAt(i))) {
        System.out.print(word.charAt(i));
        correctCount++;
      }
      else {
        System.out.print(" - ");
      }
    }
    return (word.length() == correctCount);
  }
}
