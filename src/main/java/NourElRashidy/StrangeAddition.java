package NourElRashidy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Nour on 08/08/2016.
 */
public class StrangeAddition {
    public static void main(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer>res = new ArrayList<Integer>();
        int t = -1;
        boolean k1 = false, k2 = false;
        for(int i=0; i<n; i++){
            int tmp = scanner.nextInt();
            if(tmp==0||tmp==100){
                res.add(tmp);
            }
            else if(k1 == false && tmp%10 == 0){
                res.add(tmp);
                k1 = true;
            }
            else if(k2 == false && tmp<10){
                res.add(tmp);
                k2 = true;
            }
            else{
                t=tmp;
            }
        }

        if(k1==false && k2==false && t!=-1) {
            res.add(t);
        }
        Collections.sort(res);

        System.out.println(res.size());
        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i));
            System.out.print(' ');
        }
    }
}
