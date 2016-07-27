package Omar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ShellGame {

    public static void main(String... args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner input = new Scanner(new File("input.txt"));
        int current = input.nextInt();
        for (int i = 0; i < 3; ++i) {
            int x = input.nextInt(), y = input.nextInt();
            if (current == x)
                current = y;
            else if (current == y)
                current = x;
        }
        PrintWriter output = new PrintWriter("output.txt", "UTF-8");
        output.println(current);
        output.close();
        input.close();
    }
}
