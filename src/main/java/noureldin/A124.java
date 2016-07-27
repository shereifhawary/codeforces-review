package noureldin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by noureldin on 7/27/16.
 */
public class A124 {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int getNext() throws Exception{
        if(br == null) br = new BufferedReader(new InputStreamReader(System.in));
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception{
        int a = getNext(),b = getNext(),r = getNext();
        String [] out = {"First","Second"};
        System.out.println(out[(2*r > Math.min(a,b)) ? 1 : 0]);
    }
}

