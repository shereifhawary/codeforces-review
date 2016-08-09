package shokry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ShellGame {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner in = new Scanner(new File("input.txt"));
        boolean[] cups = {false, false, false};
        cups[in.nextInt() - 1] = true;
        for (int k = 0; k < 3; ++k) {
            int i = in.nextInt() - 1;
            int j = in.nextInt() - 1;
            // swap
            cups[i] ^= cups[j];
            cups[j] ^= cups[i];
            cups[i] ^= cups[j];
        }
        PrintWriter out = new PrintWriter("output.txt", "UTF-8");
        for (int i = 0; i < 3; ++i) {
            if (cups[i]) {
                out.println(i + 1);
                break;
            }
        }
        in.close();
        out.close();
    }
}
