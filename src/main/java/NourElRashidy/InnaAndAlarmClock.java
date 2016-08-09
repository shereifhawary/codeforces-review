package NourElRashidy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
/**
 * Created by Nour on 08/08/2016.
 */
public class InnaAndAlarmClock {
    public static void main(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        boolean[] ux = new boolean[105];
        boolean[] uy = new boolean[105];

        int rx =0, ry=0;
        for(int i=0; i<n; i++){
            int x = scanner.nextInt(), y = scanner.nextInt();
            if(ux[x] == false){
                rx++;
            }

            if(uy[y] == false){
                ry++;
            }
            ux[x]=true;
            uy[y]=true;
        }

        System.out.println(Math.min(rx, ry));

    }
}
