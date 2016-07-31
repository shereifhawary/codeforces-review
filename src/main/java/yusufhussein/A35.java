package yusufhussein;

import java.io.*;
import java.util.*;

/**
 * Created by Yusuf on 7/24/2016.
 */
public class A35 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new FileInputStream("input.txt"));
        boolean cups[] = new boolean[3];
        int begin = input.nextInt() - 1;
        cups[begin] = true;
        for (int i = 0; i < 3; ++i) {
            int cupA = input.nextInt() - 1;
            int cupB = input.nextInt() - 1;
            boolean tmp = cups[cupA];
            cups[cupA] = cups[cupB];
            cups[cupB] = tmp;
        }
        PrintWriter out = new PrintWriter(new File("output.txt"));
        for (int i = 0; i < 3; ++i) {
            if (cups[i]) {
                out.println(i + 1);
                break;
            }
        }
        out.close();
    }
}