package Nada;

import java.util.Scanner;

/**
 * Created by Nada on 8/1/16.
 */
public class OnSegmentsOwnPoints {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),a=0,b=0,ans=0;
        int[] arr = new int[120];
        for(int i=0; i<n; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (i == 0) {
                a = x;
                b = y;
            }
            if(i != 0)
                for (int j = x + 1; j <= y; j++) arr[j] = 1;
        }
        for(int i=a+1; i<=b; i++){
            if(arr[i]==0) ans++;
        }
        System.out.println(ans);
    }
}
