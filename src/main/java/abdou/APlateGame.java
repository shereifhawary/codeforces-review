package abdou;

import java.util.Scanner;

/**
 * Created by fox on 27/07/2016.
 */
public class APlateGame {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int r = input.nextInt();

        if(Math.min(a,b) >= 2*r){
            System.out.println("First");
        }else{
            System.out.println("Second");
        }

    }
}
