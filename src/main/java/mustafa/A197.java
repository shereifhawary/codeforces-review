package mustafa;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mustafa on 7/27/2016.
 */
public class A197 {
    public static void main (String [] arjs)
    {
        int a,b,r,player=0;
        Scanner reader=new Scanner(System.in);
        a=reader.nextInt();
        b=reader.nextInt();
        r=reader.nextInt();
        r+=r;
        a=(a/r)*(b/r);
        a=a-(b/r/2);
        if(a>0)
            System.out.println("First");
        else
            System.out.println("Second");
    }
}
