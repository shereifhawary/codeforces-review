package yusufhussein;


/**
 * Created by Yusuf on 7/24/2016.
 * A. On Segment's Own Points
 */

import java.util.*;

public class A397 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[][] = new int[n][2];
        boolean v[] = new boolean[105];
        for (int i = 0; i < n; ++i) {
            a[i][0] = input.nextInt();
            a[i][1] = input.nextInt();
        }
        for (int i = 1; i < n; ++i) {
            for (int j = a[i][0] + 1; j <= a[i][1]; ++j) {
                v[j] = true;
            }
        }
        int out = 0;
        for (int j = a[0][0] + 1; j <= a[0][1]; ++j) {
            if (!v[j]) {
                ++out;
            }
        }
        System.out.println(out);
    }
}