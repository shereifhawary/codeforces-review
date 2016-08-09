package shokry;

import java.util.Scanner;

public class Nineteen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = 0, i = 0, e = 0, t = 0;
        for (int j = 0; j < s.length(); ++j) {
            if (s.charAt(j) == 'n')
                ++n;
            if (s.charAt(j) == 'i')
                ++i;
            if (s.charAt(j) == 'e')
                ++e;
            if (s.charAt(j) == 't')
                ++t;
        }
        System.out.println(Math.min((n - 1) / 2, Math.min(i, Math.min(e / 3, t))));
    }
}
