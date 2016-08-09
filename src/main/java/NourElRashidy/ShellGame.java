package NourElRashidy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Nour on 08/08/2016.
 */
public class ShellGame {
    public static void main(String... args) throws Exception {
        Scanner scanner = new Scanner(new File("input.txt"));
        int n = scanner.nextInt();
        int[] arr = new int[3];
        arr[n-1]=1;
        for(int i=0; i<3; i++){
            int t1 = scanner.nextInt();
            int t2 = scanner.nextInt();

            int temp = arr[t1-1];
            arr[t1-1]=arr[t2-1];
            arr[t2-1]=temp;
        }

        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
        if(arr[0] == 1) {
            writer.print(1);
        }

        if(arr[1] == 1) {
            writer.print(2);
        }

        if(arr[2] == 1) {
            writer.print(3);
        }

        writer.close();
        scanner.close();
    }
}
