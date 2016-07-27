package Omar;

import java.util.Scanner;
import java.util.Vector;

public class StrangeAddition {
    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int numbers[] = new int[n];
        for (int i = 0; i < n; ++i) {
            numbers[i] = input.nextInt();
        }
        Vector<Integer> result = new Vector<Integer>();
        boolean foundTens = false;
        boolean foundOnes = false;
        for (int i = 0; i < n; ++i) {
            if (!foundTens && 10 <= numbers[i] && numbers[i] < 100 && numbers[i] % 10 == 0) {
                result.add(numbers[i]);
                foundTens = true;
            }
            if (!foundOnes && 1 <= numbers[i] && numbers[i] < 10) {
                result.add(numbers[i]);
                foundOnes = true;
            }
            if (numbers[i] == 0 || numbers[i] == 100) {
                result.add(numbers[i]);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (!foundOnes && !foundTens && 10 < numbers[i] && numbers[i] < 100) {
                result.add(numbers[i]);
                break;
            }
        }

        System.out.println(result.size());
        for (Integer aResult : result)
            System.out.print(aResult + " ");
    }
}
