import java.util.Scanner;

/**
 * Created by tdph5945 on 2016-07-24.
 */
public class Main {
    public static void main(String... args) {
        int n;
        int[] arr=new int[1000];
        int[] arr1=new int[1000];
        for(int f=0;f<1000;f++)
            arr[f]=arr1[f]=0;
        Scanner scan = new Scanner(System.in);
        n=scan.nextInt();
        for(int f=0;f<n;f++)
        {
            arr[scan.nextInt()]=1;
            arr1[scan.nextInt()]=1;
        }
        int ans=0,ans1=0;
        for(int f=0;f<=100;f++) {
            ans+=arr[f];
            ans1+=arr1[f];
        }
        if(ans<ans1)
            System.out.println(ans);
        else
            System.out.println(ans1);
    }
}