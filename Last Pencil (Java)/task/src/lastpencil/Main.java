package lastpencil;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPencils;

        // This loop is for getting and validating the number of pencils from the user
        while (true) {
            System.out.println("How many pencils would you like to use:");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("The number of pencils should be numeric");
                continue;
            }
            try {
                numberOfPencils = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
                continue;
            }
            if (numberOfPencils <= 0) {
                System.out.println("The number of pencils should be positive");
                continue;
            }
            break;
        }

        String firstPlayer;
        String secondPlayer = "Jack";

        // This loop is for getting and validating the first player from the user
        while (true) {
            System.out.println("Who will be the first (John, Jack):");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("John")) {
                firstPlayer = "John";
                secondPlayer = "Jack";
                break;
            } else if (input.equalsIgnoreCase("Jack")) {
                firstPlayer = "Jack";
                secondPlayer = "John";
                break;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }

        // Print the initial state of the game
        printPencil(numberOfPencils);

        String currentPlayer = firstPlayer;
        String winner;
        // This is the main game loop
        while (numberOfPencils > 0) {
            int pencilsToRemove = 0;
            boolean validInput = false;

            // This loop is for getting and validating the number of pencils to remove from the user
            while (!validInput) {
                if (currentPlayer.equals("Jack")) { // If it's Jack's turn
                    if (numberOfPencils == 1) { // If only one pencil is left
                        pencilsToRemove = 1;
                    } else if (numberOfPencils % 4 == 0) { // If Jack is in a winning position
                        pencilsToRemove = 3;
                    } else if (numberOfPencils % 4 == 1) { // If Jack is in a losing position
                        pencilsToRemove = new Random().nextInt(3) + 1; // Take a random number of pencils
                    } else if (numberOfPencils % 4 == 2) { // If Jack is in a winning position
                        pencilsToRemove = 1;
                    } else if (numberOfPencils % 4 == 3) { // If Jack is in a winning position
                        pencilsToRemove = 2;
                    }
                    System.out.println("Jack's turn:");
                    System.out.println(pencilsToRemove);
                    validInput = true;
                } else { // If it's John's turn
                    System.out.println(currentPlayer + "'s turn!");
                    String input = scanner.nextLine().trim();
                    try {
                        pencilsToRemove = Integer.parseInt(input);
                        if (pencilsToRemove < 1 || pencilsToRemove > 3) {
                            System.out.println("Possible values: '1', '2' or '3'");
                        } else if (pencilsToRemove > numberOfPencils) {
                            System.out.println("Too many pencils were taken");
                        } else {
                            validInput = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Possible values: '1', '2' or '3'");
                    }
                }
            }
            numberOfPencils -= pencilsToRemove;

            // Check if there are any pencils left before printing the pencils and the next player's turn
            if (numberOfPencils > 0) {
                printPencil(numberOfPencils);
                currentPlayer = currentPlayer.equals(firstPlayer) ? secondPlayer : firstPlayer;
            }
        }
        // Check if the game has ended and determine the winner
        if (numberOfPencils <= 0) {
            winner = currentPlayer.equals(firstPlayer) ? secondPlayer : firstPlayer;
            System.out.println(winner + " won!");
        }
    }
    // This method is used to print the current state of the game
    public static void printPencil(int numberOfPencils) {
        for (int i = 0; i < numberOfPencils; i++) {
            System.out.print("|");
        }
        System.out.println();
    }
}