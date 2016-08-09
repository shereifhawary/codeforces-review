package Nada;

import java.util.Scanner;

/**
 * Created by Nada on 8/1/16.
 */
public class Triangle {
    public static int dist(int x1, int y1, int x2, int y2){
        return (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
    }
    public static boolean isright(int x1, int y1, int x2, int y2, int x3, int y3){
        int s1,s2,s3;
        s1=dist(x1,y1,x2,y2);
        s2=dist(x1,y1,x3,y3);
        s3=dist(x2,y2,x3,y3);
        if(x1==x2&&y1==y2 || x1==x3&&y1==y3 || x2==x3&&y3==y2) return false;
        if(s1+s2==s3 || s1+s3==s2 || s2+s3==s1) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int x1 = reader.nextInt();
        int y1 = reader.nextInt();
        int x2 = reader.nextInt();
        int y2 = reader.nextInt();
        int x3 = reader.nextInt();
        int y3 = reader.nextInt();
        if (isright(x1, y1, x2, y2, x3, y3)) {
            System.out.println("RIGHT");
            return;
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if((i==0 || j==0) && (isright(x1,y1,x2,y2,x3+i,y3+j)||isright(x1+i,y1+j,x2,y2,x3,y3)||isright(x1,y1,x2+i,y2+j,x3,y3))){
                    System.out.println("ALMOST");
                    return;
                }
            }
        }
        System.out.println("NEITHER");
    }
}
