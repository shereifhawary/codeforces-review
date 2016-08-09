package shokry;

import java.util.Scanner;

public class InnaAndPinkPony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int i = scanner.nextInt(), j = scanner.nextInt();
        int a = scanner.nextInt(), b = scanner.nextInt();
        int[] ci = {1, n, n, 1};
        int[] cj = {m, 1, m, 1};
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 4; ++k) {
            int dx = Math.abs(i - ci[k]);
            int dy = Math.abs(j - cj[k]);
            if (ci[k] == i && cj[k] == j)
                ans = 0;
            if (dx % a != 0 || dy % b != 0|| (dx / a) % 2 != (dy / b) % 2 ||
                    (a + i > n && i <= a) || (b + j > m && m <= b))
                continue;
            ans = Math.min(ans, Math.max(dx / a, dy / b));
        }
        if (ans == Integer.MAX_VALUE)
            System.out.println("Poor Inna and pony!\n");
        else
            System.out.println(ans + "\n");
    }
}
