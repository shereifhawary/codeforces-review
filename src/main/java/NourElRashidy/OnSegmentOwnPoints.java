package NourElRashidy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
/**
 * Created by Nour on 08/08/2016.
 */

public class OnSegmentOwnPoints {
    public static void main(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] can = new boolean[105];
        for(int i=0; i<105; i++){
            can[i]=false;
        }

        int l = scanner.nextInt(), r = scanner.nextInt();
        for(int i=l; i<=r; i++){
            can[i]=true;
        }

        for(int i=1; i<n; i++){
            int tl= scanner.nextInt(), tr=scanner.nextInt();
            for(int j=tl; j<tr; j++){
                can[j]=false;
            }
        }

        int res=0;
        for(int i=l; i<r; i++){
            if(can[i] == true){
                res++;
            }
        }

        System.out.print(res);
    }
}