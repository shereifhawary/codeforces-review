package noureldin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by noureldin on 7/24/16.
 */
public class A230 {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static String getNext() throws Exception{
        if(br == null) br = new BufferedReader(new InputStreamReader(System.in));
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public static void main(String[] args) throws Exception{
        int [] CTR = new int[26];
        String line = getNext();
        for(int i = 0,L = line.length();i < L;i++) CTR[line.charAt(i) - 'a']++;
        int ans = line.length();
        ans = Math.min(ans,(CTR['n' - 'a'] - 1)/2);
        ans = Math.min(ans,CTR['e' - 'a']/3);
        ans = Math.min(ans,CTR['i' - 'a']);
        ans = Math.min(ans,CTR['t' - 'a']);
        System.out.println(ans);
    }
}
