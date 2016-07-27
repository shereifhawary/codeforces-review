package Omar;

import java.util.Scanner;

public class PlateGame {
    public static void main(String...args) {
        Scanner input = new Scanner(System.in);
        int width = input.nextInt(), height = input.nextInt(), radius = input.nextInt();
        if (radius * 2 <= width && radius * 2 <= height) {
            System.out.println("First");
        }else{
            System.out.println("Second");
        }
    }
}
