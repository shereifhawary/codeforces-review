package Nada;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Nada on 8/1/16.
 */
public class ShellGame {
    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tok;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tok = new StringTokenizer("");
        }

        public String next() {
            while (!tok.hasMoreTokens())
                try {
                    tok = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return tok.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
    public static int swap(int a, int b) {
        return a;
    }
    public static void main(String args[]) {
        try {
            InputReader is = new InputReader(new FileInputStream("input.txt"));
            PrintWriter os = new PrintWriter("output.txt", "UTF-8");
            //  Scanner is = new Scanner(System.in);
            int n = is.nextInt();
            int []arr={0,0,0};
            arr[n-1]=1;
            int a1 = is.nextInt();
            int b1 = is.nextInt();
            arr[a1-1] = swap(arr[b1-1], arr[b1-1]=arr[a1-1]);
            a1 = is.nextInt();
            b1 = is.nextInt();
            arr[a1-1] = swap(arr[b1-1], arr[b1-1]=arr[a1-1]);
            a1 = is.nextInt();
            b1 = is.nextInt();
            arr[a1-1] = swap(arr[b1-1], arr[b1-1]=arr[a1-1]);
            if(arr[0]==1) os.write(String.valueOf(1));
            else if(arr[1]==1) os.write(String.valueOf(2));
            else os.write(String.valueOf(3));
            os.close();
            is.reader.close();

        } catch (IOException e) {

        }
    }
}

