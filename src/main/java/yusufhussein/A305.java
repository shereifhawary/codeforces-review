package yusufhussein;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yusuf on 7/27/2016.
 * A. Strange Addition
 */

public class A305 {
    public static int onePos(int num) {
        int ret = 0;
        for (int i = 0; i < 3; ++i) {
            if (num % 10 != 0) ret |= (1 << i);
            num /= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> out = new ArrayList<Integer>();
        boolean flag[] = new boolean[6];
        int n = input.nextInt(), all = -1;
        for (int i = 0, num; i < n; ++i) {
            num = input.nextInt();
            int tmp = onePos(num);
            if (tmp == 3) {
                flag[3] = true;
                all = num;
            } else if (!flag[tmp]) {
                flag[tmp] = true;
                out.add(num);
            }
        }
        if (!flag[1] && !flag[2] && flag[3]) {
            out.add(all);
        }
        System.out.println(out.size());
        for (int num : out) {
            System.out.print(num + " ");
        }
    }
}