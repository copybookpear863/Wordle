import java.util.Scanner;

public class Wordle {
    
    public static void main(String[] args) {
        String[] words = {"hello", "broke", "money", "erupt", "power"};
        int w = (int)(Math.random()*(words.length - 1));
        String word = words[w];
        Scanner input = new Scanner(System.in);
        int g = 6;
        String guess = "";
        System.out.println("Welcome to my version of Wordle! For now, this is a super simple and basic version that I made to get a feel for the coding process."); 
        System.out.println("I'm currently working on letting the program choose a random 5-letter word from the dictionary instead of having hard coded values. Make sure to check back in the future for an updated version!");
        System.out.println("\nHere are some simple rules:");
        System.out.println("\nYou have 6 guesses to determine which 5-letter word the program has chosen.");
        System.out.println("\nEach guess must be 5 letters long and after pressing enter, the program will tell you what letters you guessed correctly."); 
        System.out.println("For example, if you guess 'water' and the program ouputs XXCYY, that means the first two letters are wrong, the third letter is right but is in the wrong place, and the last two letters are correct and in the right place.");
        System.out.println("\nGood luck!");
        while (!guess.equals(word) && g > 0) {
            System.out.println("\nYou have " + g + " guesses remaining.");
            guess = input.nextLine();
            if (guess.length() != 5) {
                System.out.println("\nYour guess must be 5 characters!");
                continue;
            }
            for (int i = 0; i < word.length(); i++) {
                boolean didBreak = false;
                for (int j = 0; j < word.length(); j++) {
                    if (guess.charAt(i) == word.charAt(i)) {
                        System.out.print("Y");
                        didBreak = true;
                        break;
                    } 
                    if (guess.charAt(i) == word.charAt(j)) {
                        System.out.print("C");
                        didBreak = true;
                        break;
                    }
                }
                if (!didBreak) {
                    System.out.print("X");
                }
            }
            g--;
        } 
        if (guess.equals(word)) {
            System.out.println("\nYou guessed it! Good job!");
        } else {
            System.out.println("\nBetter luck next time! The word was: " + word);
        }
    }
}
