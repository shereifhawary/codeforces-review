package noureldin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by noureldin on 7/24/16.
 */
public class A232 {

    private static BufferedReader br;
    private static StringTokenizer st;
    private static int getNext() throws Exception{
        if(br == null) br = new BufferedReader(new InputStreamReader(System.in));
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception{
        int [] used = new int[100];
        int n = getNext(),L=0,R=0;
        for(int i = 0;i < n;i++){
            int l = getNext(),r = getNext();
            if(i == 0){
                L = l;
                R = r;
                continue;
            }
            for(int j = l;j < r;j++) used[j] = 1;
        }
        int ctr = 0;
        for(int i = L;i < R;i++) ctr += 1 - used[i];
        System.out.println(ctr);
    }
}
 