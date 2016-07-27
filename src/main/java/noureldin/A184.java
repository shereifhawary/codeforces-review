package noureldin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by noureldin on 7/24/16.
 */
public class A184 {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int getNext() throws Exception{
        if(br == null) br = new BufferedReader(new InputStreamReader(System.in));
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    private static int [] A,B;
    private static int n;

    private static int bt(int i,boolean a,boolean b,boolean c,boolean type){
        if(i == n) return 0;
        boolean x = A[i]%10 == 0,y = ((A[i]%100) / 10) == 0,z = (A[i]/100) == 0;
        int k = bt(i + 1,a,b,c,false),q = 0;
        if((x || a) && (y || b) && (z || c)){
            q = bt(i + 1,a && x,b && y,c && z,false) + 1;
        }
        if(type) {
            if (q > k) {
                bt(i + 1, a && x, b && y, c && z, true);
                System.out.printf("%d ", A[i]);
            } else bt(i + 1, a, b, c, true);
        }
        return Math.max(q,k);
    }


    public static void main(String[] args) throws Exception {
        n = getNext();
        A = new int[n];
        for(int i = 0;i < n;i++) A[i] = getNext();
        int ans = bt(0,true,true,true,false);
        System.out.println(ans);
        bt(0,true,true,true,true);
    }
}
