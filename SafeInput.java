import java.util.Scanner;

public class SafeInput {

    /**
     * Prompts the user until they enter an integer between low and high (inclusive).
     */
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int value = 0;
        boolean ok = false;
        while (!ok) {
            System.out.print(prompt);
            String line = console.nextLine().trim();
            try {
                value = Integer.parseInt(line);
                if (value < low || value > high) {
                    System.out.printf("Please enter an integer between %d and %d.%n", low, high);
                } else {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("That's not an integer. Please try again.");
            }
        }
        return value;
    }

    /**
     * Prompts the user for a Y/N answer. Returns true for yes, false for no.
     */
    public static boolean getYNConfirm(Scanner console, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = console.nextLine().trim();
            if (line.length() == 0) {
                System.out.println("Please enter Y or N.");
                continue;
            }
            char c = Character.toUpperCase(line.charAt(0));
            if (c == 'Y') return true;
            if (c == 'N') return false;
            System.out.println("Please respond with Y or N.");
        }
    }
}
