import java.util.Random;
import java.util.Scanner;

public class Lab09_ArrayStuff {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rnd = new Random();

        // Task 1: declare array length 100
        int[] dataPoints = new int[100];
        System.out.println("Task 1: Created int[] dataPoints of length " + dataPoints.length);

        // Task 2: initialize each element to random value 1..100
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1; // 1-100 inclusive
        }
        System.out.println("Task 2: Initialized dataPoints with random 1..100 values.");

        // Task 3: display values on one line separated by " | "
        System.out.println("\nTask 3: dataPoints values:");
        for (int i = 0; i < dataPoints.length; i++) {
            if (i == dataPoints.length - 1) {
                System.out.print(dataPoints[i]); // last element - no trailing delimiter
            } else {
                System.out.print(dataPoints[i] + " | ");
            }
        }
        System.out.println(); // newline after the long line

        // Task 4: calculate sum and average
        int sum = 0;
        for (int v : dataPoints) {
            sum += v;
        }
        double average = (double) sum / dataPoints.length;
        System.out.println("\nTask 4: The sum of all values in dataPoints is: " + sum + ".");
        System.out.printf("Task 4: The average of the random array dataPoints is: %.2f.%n", average);

        // ---------- Part 2: Linear scan (search) ----------
        // Task 5: prompt user for a search value (1..100)
        System.out.println("\nTask 5: Search for how many times a value appears.");
        int searchValue = SafeInput.getRangedInt(console, "Enter an integer to count occurrences (1-100): ", 1, 100);

        // Task 6: count occurrences
        int count = 0;
        for (int v : dataPoints) {
            if (v == searchValue) count++;
        }
        System.out.printf("Task 6: The value %d was found %d time(s) in dataPoints.%n", searchValue, count);

        // Task 7: prompt again and find first index (break when found)
        System.out.println("\nTask 7: Search for the first occurrence of a value.");
        int searchValue2 = SafeInput.getRangedInt(console, "Enter an integer to find first index (1-100): ", 1, 100);
        int foundIndex = -1; // -1 indicates not found
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchValue2) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex >= 0) {
            System.out.printf("Task 7: The value %d was found at array index %d.%n", searchValue2, foundIndex);
        } else {
            System.out.printf("Task 7: The value %d was NOT found in the array.%n", searchValue2);
        }

        // Task 8: find min and max values
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) min = dataPoints[i];
            if (dataPoints[i] > max) max = dataPoints[i];
        }
        System.out.printf("Task 8: The minimum value in dataPoints is: %d.%n", min);
        System.out.printf("Task 8: The maximum value in dataPoints is: %d.%n", max);

        // Task 9: static method getAverage test
        System.out.printf("Task 9: Average of dataPoints is: %.2f%n", getAverage(dataPoints));

        // Done

    }

    /**
     * Task 9: Return average of int array as double
     */
    public static double getAverage(int values[]) {
        if (values == null || values.length == 0) return 0.0;
        long sum = 0;
        for (int v : values) sum += v;
        return (double) sum / values.length;
    }
}
