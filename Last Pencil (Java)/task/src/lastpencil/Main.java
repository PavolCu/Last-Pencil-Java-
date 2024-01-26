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

        printPencilAndTurn(numberOfPencils, firstPlayer);
    }

    public static void printPencilAndTurn(int numberOfPencils, String firstPlayer) {

        System.out.println("|".repeat(Math.max(0, numberOfPencils)));
        System.out.println(firstPlayer + " is going first!");
    }
}
