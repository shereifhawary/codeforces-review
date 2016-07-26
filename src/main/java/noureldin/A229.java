package noureldin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by noureldin on 7/24/16.
 */
public class A229 {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int getNext() throws Exception{
        if(br == null) br = new BufferedReader(new InputStreamReader(System.in));
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception{
        int [] X = new int[101];
        int [] Y = new int[101];
        int ctrX = 0,ctrY = 0;
        int n = getNext(),x,y;
        for(int i = 0;i < n;i++){
            x = getNext();
            y = getNext();
            if(X[x] == 0) ctrX++;
            if(Y[y] == 0) ctrY++;
            X[x] = Y[y] = 1;
        }
        System.out.println(Math.min(ctrX,ctrY));
    }
}
