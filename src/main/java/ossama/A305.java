package ossama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by ahmed on 7/31/16.
 */
public class A305 {
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

    public static void main(String[] args) {
        A305 program = new A305();
        program.begin();
    }

    public void begin() {
        InputReader in = new InputReader(System.in);
        int n = Integer.parseInt(in.next());
        int []d = new int[n];
        for (int i = 0; i < n; i++)
            d[i] = Integer.parseInt(in.next());
        Arrays.sort(d);

        Vector<Integer> ans = new Vector<Integer>();
        for (int i = 0; i < n; i++) {
            if (d[i] == 0)
                continue;
            for (int j = i + 1; j < n; j++) {
                if (d[j] == d[i])
                    continue;
                for (int k = j + 1; k < n; k++) {
                    if (d[k] == d[j])
                        continue;

                    int a = get(d[i], 0) + get(d[j], 0) + get(d[k], 0);
                    int b = get(d[i], 1) + get(d[j], 1) + get(d[k], 1);
                    int c = get(d[i], 2) + get(d[j], 2) + get(d[k], 2);

                    if (a <= 1 && b <= 1 && c <= 1 && ans.size() == 0) {
                        ans.add(d[i]);
                        ans.add(d[j]);
                        ans.add(d[k]);
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            if (d[i] == 0)
                continue;
            for (int j = i + 1; j < n; j++) {
                if (d[j] == d[i])
                    continue;
                int a = get(d[i], 0) + get(d[j], 0);
                int b = get(d[i], 1) + get(d[j], 1);
                int c = get(d[i], 2) + get(d[j], 2);
                if (a <= 1 && b <= 1 && c <= 1 && ans.size() == 0) {
                    ans.add(d[i]);
                    ans.add(d[j]);
                }
            }
        }

        if (ans.size() == 0)
            ans.add(d[n - 1]);
        if (d[0] == 0 && d[n - 1] != 0)
            ans.add(d[0]);

        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
        System.out.println();

    }

    int get(int x, int pos) {
        if (pos == 0)
            return x % 10 > 0 ? 1 : 0;
        if (pos == 1)
            return (x % 100) / 10 > 0 ? 1 : 0;
        if (pos == 2)
            return x / 100 > 0 ? 1 : 0;
        return -1;
    }


}



