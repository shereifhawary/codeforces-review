package shokry;

import java.util.Scanner;

public class PlateGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int r = in.nextInt();
        if (Math.min(a, b) < 2 * r) {
            System.out.println("Second");
        } else {
            System.out.println("First");
        }
    }
}
