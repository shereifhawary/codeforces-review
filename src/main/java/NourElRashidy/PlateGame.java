package NourElRashidy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
/**
 * Created by Nour on 08/08/2016.
 */
public class PlateGame {
    public static void main(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int r = scanner.nextInt();

        if(2 * r > Math.min(a, b)){
            System.out.println("Second");
        }
        else{
            System.out.println("First");
        }
    }
}
