package lastpencil;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        printPencilAndTurn();
    }

    public static void printPencilAndTurn() {
        Random random = new Random();
        int numberOfPencils = random.nextInt(10) + 1;
        StringBuilder pencils = new StringBuilder();

        for (int i = 0; i < numberOfPencils; i++) {
            pencils.append("|");
        }

        System.out.println(pencils);
        System.out.println("Your turn!");
    }
}
