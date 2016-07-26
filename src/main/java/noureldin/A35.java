package noureldin;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by noureldin on 7/24/16.
 */
public class A35 {
    private static BufferedReader br;
    private static PrintWriter pw;
    private static StringTokenizer st;
    private static int getNext() throws Exception{
        if(br == null) br = new BufferedReader(new FileReader("input.txt"));
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
    private static void write(int x) throws Exception {
        if(pw == null) pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        pw.println(x);
    }

    public static void main(String[] args) throws Exception{
        int [] state = new int [3];
        int x,y;
        x = getNext() - 1;
        state[x] = 1;
        for(int i = 0;i < 3;i++){
            x = getNext() - 1; y = getNext() - 1;
            if(x != y) {
                int t = state[x];
                state[x] = state[y];
                state[y] = t;
            }
        }
        for(int i = 0;i < 3;i++) if(state[i] == 1) write(i+1);
        pw.close();
    }

}
