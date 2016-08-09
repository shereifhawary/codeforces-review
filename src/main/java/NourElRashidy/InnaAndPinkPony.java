package NourElRashidy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Nour on 08/08/2016.
 */
public class InnaAndPinkPony {
    public static void main(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),
                m = scanner.nextInt();

        int i = scanner.nextInt(),
                j = scanner.nextInt(),
                a = scanner.nextInt(),
                b = scanner.nextInt();

        if((i == 1 || i == n) && (j == 1 || j == m)) {
            System.out.println(0);
            return;
        }

        if((a + i > n && i - a < 1) || (b + j > m && j - b < 1)) {
            System.out.println("Poor Inna and pony!");
            return;
        }

        int res = 1000000000;
        if(Math.abs(j - m) % b == 0 && Math.abs(i - 1) % a == 0 && (Math.abs(j - m)/b)%2 == (Math.abs(i - 1)/a)%2) {
            res = Math.min(res, Math.max(Math.abs(j - m) / b, Math.abs(i - 1) / a));
        }
        if(Math.abs(j - 1) % b == 0 && Math.abs(i - n) % a == 0 && (Math.abs(j - 1)/b)%2 == (Math.abs(i - n)/a)%2) {
            res = Math.min(res, Math.max(Math.abs(j - 1) / b, Math.abs(i - n) / a));
        }
        if(Math.abs(j - m) % b == 0 && Math.abs(i - n) % a == 0 && (Math.abs(j - m)/b)%2 == (Math.abs(i - n)/a)%2) {
            res = Math.min(res, Math.max(Math.abs(j - m) / b, Math.abs(i - n) / a));
        }
        if(Math.abs(j - 1) % b == 0 && Math.abs(i - 1) % a == 0 && (Math.abs(j - 1)/b)%2 == (Math.abs(i - 1)/a)%2) {
            res = Math.min(res, Math.max(Math.abs(j - 1) / b, Math.abs(i - 1) / a));
        }

        if(res == 1000000000) {
            System.out.println("Poor Inna and pony!");
        }
        else{
            System.out.println(res);
        }
    }
}
