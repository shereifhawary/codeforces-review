package Nada;

import java.util.Scanner;

/**
 * Created by Nada on 8/1/16.
 */
public class Nineteen {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0, i=0, e=0, t=0, tmp=0;
        String s = scanner.next();
        for(int j=0; j<s.length(); j++) {
            if (s.charAt(j) == 'n') n++;
            if (s.charAt(j) == 'i') i++;
            if (s.charAt(j) == 't') t++;
            if (s.charAt(j) == 'e') e++;
        }
        if(n>=3) tmp=1;
        int ans = Math.min(Math.min((n-3)/2+tmp,e/3),Math.min(i,t));
        System.out.println(Math.max(ans,0));
    }

}
