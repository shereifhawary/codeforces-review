package shokry;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] x = new int[3];
        int[] y = new int[3];
        for (int i = 0; i < 3; ++i) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        if (isRight(x, y)) {
            System.out.println("RIGHT");
            return;
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 3; ++i) {
            for (int k = 0; k < 4; ++k) {
                x[i] += dx[k];
                y[i] += dy[k];
                if (isRight(x, y)) {
                    System.out.println("ALMOST");
                    return;
                }
                x[i] -= dx[k];
                y[i] -= dy[k];
            }
        }
        System.out.println("NEITHER");

    }

    private static boolean isRight(int []x, int []y) {
        int a = (x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]);
        int b = (x[0] - x[2]) * (x[0] - x[2]) + (y[0] - y[2]) * (y[0] - y[2]);
        int c = (x[1] - x[2]) * (x[1] - x[2]) + (y[1] - y[2]) * (y[1] - y[2]);
        return a > 0 && b > 0 && c > 0 && (a == b + c || b == a + c || c == a + b);
    }
}
