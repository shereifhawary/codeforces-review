package noureldin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by noureldin on 7/24/16.
 */
public class A18 {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int getNext() throws Exception{
        if(br == null) br = new BufferedReader(new InputStreamReader(System.in));
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    private static Boolean isRight(int [] X,int [] Y){
        int [] dist = new int [3];
        int idx = 0;
        Boolean ret = true;
        for (int i = 0;i < 3;i++) for(int j = 0;j < i;j++){
            dist[idx] = (X[i] - X[j])*(X[i] - X[j]) + (Y[i] - Y[j])*(Y[i] - Y[j]);
            ret &= dist[idx] > 0;
            idx++;
        }
        ret &= dist[0] + dist[1] == dist[2] || dist[0] + dist[2] == dist[1] || dist[1] + dist[2] == dist[0];
        return ret;
    }

    private static Boolean isAlmost(int [] X,int [] Y){
        for(int i = 0;i < 3;i++){
            for(int dx = -1;dx <= 1;dx++) for(int dy = -1;dy <= 1;dy++) if(Math.abs(dx) + Math.abs(dy) == 1){
                X[i] += dx;
                Y[i] += dy;
                if(isRight(X,Y)) return true;
                X[i] -= dx;
                Y[i] -= dy;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        int[] X = new int[3];
        int[] Y = new int[3];
        for (int i = 0; i < 3; i++) {
            X[i] = getNext();
            Y[i] = getNext();
        }
        if (isRight(X, Y)) System.out.println("RIGHT");
        else if (isAlmost(X, Y)) System.out.println("ALMOST");
        else System.out.println("NEITHER");
    }
}
