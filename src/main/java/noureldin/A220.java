package noureldin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by noureldin on 7/24/16.
 */
public class A220 {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int getNext() throws Exception{
        if(br == null) br = new BufferedReader(new InputStreamReader(System.in));
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
    private static int oo = Integer.MAX_VALUE;
    private static int get(int x,int y,int a,int b){
        //System.out.printf("(%d,%d) * (%d,%d)\n",x,y,a,b);
        int ret = 0;
        if(x%a!=0 || y%b != 0) ret = oo;
        else {
            a = x / a;
            b = y / b;
            if((a&1) != (b&1)) ret = oo;
            else ret = Math.max(a, b);
        }
        //System.out.printf("(%d,%d) * (%d,%d) = %d\n",x,y,a,b,ret);
        return ret;
    }
    private static Boolean good(int x,int dx,int n){
        if(x > dx) return true;
        return n - x >= dx;
    }

    public static void main(String[] args) throws Exception{
        int m = getNext(),n = getNext(),i = getNext(),j = getNext(),a = getNext(),b = getNext();
        int ans = oo;
        ans = Math.min(ans,get(i-1,j-1,a,b));
        ans = Math.min(ans,get(i-1,n-j,a,b));
        ans = Math.min(ans,get(m-i,j-1,a,b));
        ans = Math.min(ans,get(m-i,n-j,a,b));
        if((!good(i,a,m) || !good(j,b,n)) && ans != 0)ans = oo;
        if(ans == oo) System.out.println("Poor Inna and pony!");
        else System.out.println(ans);
    }

}
