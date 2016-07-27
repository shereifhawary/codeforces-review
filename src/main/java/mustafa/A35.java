package mustafa;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mustafa on 7/27/2016.
 */
public class A35 {
    public static void main (String [] arjs)throws Exception {
        Scanner reader =new Scanner(new File("input.txt"));
        int n=reader.nextInt();
        int ar[]=new int[4];
        ar[n]=1;
        int x=0,y=0,z = 0;
        for(int i =0;i<3;i++)
        {
            x=reader.nextInt();
            y=reader.nextInt();
            z=ar[x];
            ar[x]=ar[y];
            ar[y]=z;
        }
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
        for(int i=1;i<=3;i++)
        {
            if(ar[i]==1)
            {
                writer.println(""+i);
            }
        }
        writer.close();
    }
}
