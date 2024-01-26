package lastpencil;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        int numberOfPencils = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Who will be the first (John, Jack):");
        String firstPlayer = scanner.nextLine();
        String secondPlayer = firstPlayer.equals("John") ? "Jack" : "John";

        String currentPlayer = firstPlayer;

        while (numberOfPencils > 0) {
            printPencilAndTurn(numberOfPencils, currentPlayer);
            System.out.println(currentPlayer + "'s turn:");
            int pencilsToRemove = scanner.nextInt();
            numberOfPencils -= pencilsToRemove;

            currentPlayer = currentPlayer.equals(firstPlayer) ? secondPlayer : firstPlayer;
        }
    }

    public static void printPencilAndTurn(int numberOfPencils, String currentPlayer) {

        System.out.println("|".repeat(Math.max(0, numberOfPencils)));

    }
}
