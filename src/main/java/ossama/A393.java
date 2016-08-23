package ossama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by ahmed on 7/31/16.
 */
public class A393 {
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
        A393 program = new A393();
        program.begin();
    }
    public void begin() {
        InputReader in = new InputReader(System.in);
        String s; s = in.next();
        int []cnt = new int[26];
        for (int i = 0; i < s.length(); i++)
            cnt[s.charAt(i) - 'a']++;
        int ans = 0;
        while (true) {
            String nineteen = "nineteen";
            if (ans > 0)
                nineteen = "ineteen";
            boolean valid = true;
            for (int i = 0; i < nineteen.length(); i++) {
                if (cnt[nineteen.charAt(i) - 'a'] == 0) {
                    valid = false;
                    break;
                }
                cnt[nineteen.charAt(i) - 'a'] -= 1;
            }
            if (valid)
                ans++;
            else
                break;
        }
        System.out.println(ans);
    }
}
