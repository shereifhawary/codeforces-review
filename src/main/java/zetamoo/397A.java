import java.util.Scanner;

/**
 * Created by tdph5945 on 2016-07-24.
 */
public class Main {
    public static void main(String... args) {
        int n,a,b,c,d;
        int[] arr=new int[1000];
        for(int f=0;f<1000;f++)
            arr[f]=1;
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();
        a=scan.nextInt();
        b=scan.nextInt();
        for(int f=1;f<n;f++)
        {
            c=scan.nextInt();
            d=scan.nextInt();
            for(int f1=c+1;f1<=d;f1++)
                arr[f1]=0;
        }
        int ans=0;
        for(int f=a+1;f<=b;f++) {
            ans+=arr[f];
        }
        System.out.println(ans);
    }
}