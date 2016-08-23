package ossama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by ahmed on 7/31/16.
 */
public class A390 {
    class InputReader {
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
    public static void main(String []args) {
        A390 program = new A390();
        program.begin();
    }
    public void begin() {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        HashSet<Integer> hsx = new HashSet<Integer>(), hsy = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            Integer x = in.nextInt(), y = in.nextInt();
            hsx.add(x);
            hsy.add(y);
        }
        System.out.println(Math.min(hsx.size(), hsy.size()));
    }
}
