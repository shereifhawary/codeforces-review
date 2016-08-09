package Nada;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Nada on 8/1/16.
 */
public class InnaAndAlarmClock {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        for(int i=0; i<n; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            s1.add(x);
            s2.add(y);
        }
        System.out.println(Math.min(s1.size(),s2.size()));
    }
}
