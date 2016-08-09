package NourElRashidy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
/**
 * Created by Nour on 08/08/2016.
 */
public class Triangle {
    public static int getD(int x, int y, int a, int b){
        return (x-a)*(x-a) + (y-b)*(y-b);
    }

    public static boolean right(int x1, int y1, int x2, int y2, int x3, int y3){
        int a=getD(x1,y1,x2,y2);
        int b=getD(x1,y1,x3,y3);
        int c=getD(x3,y3,x2,y2);

        if(a!=0 && b!=0 && c!=0 && (a+b==c || a+c==b || b+c==a))
            return true;

        return false;
    }
    public static void main(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int x1= scanner.nextInt(),
                y1= scanner.nextInt(),
                x2= scanner.nextInt(),
                y2= scanner.nextInt(),
                x3= scanner.nextInt(),
                y3= scanner.nextInt();

        boolean Right = false;
        boolean Almost = false;

        if(right(x1, y1, x2, y2, x3, y3)){
            System.out.println("RIGHT");
            Right = true;
        }
        else{
            int arx[]={1,-1,0,0}, ary[]={0,0,1,-1};

            for(int i=0; i<4; i++){
                if(right(x1+arx[i],y1+ary[i],x2,y2,x3,y3) || right(x1,y1,x2+arx[i],y2+ary[i],x3,y3) || right(x1,y1,x2,y2,x3+arx[i],y3+ary[i])){
                    Almost=true;
                    break;
                }
            }
        }

        if(Almost)
            System.out.println("ALMOST");
        else if(!Right)
            System.out.println("NEITHER");
    }
}
