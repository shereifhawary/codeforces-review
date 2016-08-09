package shokry;

import java.util.Scanner;

public class OnSegmentsOwnPoints {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] vis = new boolean[101];
        int l1 = in.nextInt(), r1 = in.nextInt();
        for (int i = 1; i < n; ++i) {
            int l = in.nextInt(), r = in.nextInt();
            for (int j = l; j < r; ++j)
                vis[j] = true;
        }
        int cnt = 0;
        for (int i = l1; i < r1; ++i)
            cnt += vis[i] ? 0 : 1;
        System.out.println(cnt);
    }
}
