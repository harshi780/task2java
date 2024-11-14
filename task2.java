import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("Welcome to the NUMBER GUESSING GAME!");
        System.out.printf("You have %d rounds, each with %d attempts to guess the number.\n\n", MAX_ROUNDS, MAX_ATTEMPTS);

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int targetNumber = random.nextInt(MAX_RANGE) + MIN_RANGE;
            int attemptsLeft = MAX_ATTEMPTS;
            int roundScore = 0;

            System.out.printf("Round %d: Guess the number between %d and %d.\n", round, MIN_RANGE, MAX_RANGE);

            while (attemptsLeft > 0) {
                System.out.printf("You have %d attempts left. Enter your guess: ", attemptsLeft);
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == targetNumber) {
                    roundScore = attemptsLeft + 1;
                    totalScore += roundScore;
                    System.out.printf("Congratulations! You've guessed it right in %d attempts. Round Score = %d\n", (MAX_ATTEMPTS - attemptsLeft), roundScore);
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.printf("Too low! Try a higher number.\n");
                } else {
                    System.out.printf("Too high! Try a lower number.\n");
                }
            }

            if (attemptsLeft == 0) {
                System.out.printf("Out of attempts! The correct number was %d.\n", targetNumber);
            }
            System.out.printf("End of Round %d. Total Score = %d\n\n", round, totalScore);
        }

        System.out.printf("Game Over! Your final score is %d.\n", totalScore);
        scanner.close();
    }
}
