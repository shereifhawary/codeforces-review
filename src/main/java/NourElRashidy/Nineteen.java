package NourElRashidy;
import java.util.Scanner;

/**
 * Created by Nour on 08/08/2016.
 */
public class Nineteen {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        int cntN=0, cntE=0, cntT=0, cntI=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'n'){
                cntN++;
            }
            else if(s.charAt(i) == 'e'){
                cntE++;
            }
            else if(s.charAt(i) == 't'){
                cntT++;
            }
            else if(s.charAt(i) == 'i'){
                cntI++;
            }
        }

        int res = Math.min(Math.min(cntT, cntI), Math.min((cntN - 1) / 2, cntE/3));
        System.out.print(res);
    }
}
