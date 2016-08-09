package shokry;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InnaAndAlarmClock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<Integer> xs = new HashSet<Integer>(), ys = new HashSet<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = in.nextInt(), y = in.nextInt();
            xs.add(x);
            ys.add(y);
        }
        System.out.println(Math.min(xs.size(), ys.size()));
    }
}
