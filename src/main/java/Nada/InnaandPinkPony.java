package Nada;

import java.util.Scanner;

/**
 * Created by Nada on 8/1/16.
 */
public class InnaandPinkPony {
    static int n,m,i,j,a,b;
    public static int f(int x, int y){
        if((x==0 && y!=0 && n<=a) || (y==0 && x!=0 && m<=b) || x%2!=y%2) return 1000000000;
        return Math.max(x,y);
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        m = reader.nextInt();
        i = reader.nextInt();
        j = reader.nextInt();
        a = reader.nextInt();
        b = reader.nextInt();
        int ans=1000000000;
        if((i-1)%a==0 && (j-1)%b==0)
            ans=Math.min(ans, f((i-1)/a,(j-1)/b));
        if((n-i)%a==0 && (j-1)%b==0)
            ans=Math.min(ans, f((n-i)/a,(j-1)/b));
        if((n-i)%a==0 && (m-j)%b==0)
            ans=Math.min(ans, f((n-i)/a,(m-j)/b));
        if((i-1)%a==0 && (m-j)%b==0)
            ans=Math.min(ans, f((i-1)/a,(m-j)/b));
        if(ans==1e9) System.out.println("Poor Inna and pony!");
        else System.out.println(ans);

    }
}
