package abdou;

import java.util.Scanner;

/**
 * Created by fox on 24/07/2016.
 */
public class AInnaAndPinkPony {

    static int di[] = {1,0,1,0};
    static int dj[] = {1,0,0,1};

    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        int n, m , i, j , a , b;
        n = input.nextInt();
        m = input.nextInt();
        i = input.nextInt();
        j = input.nextInt();
        a = input.nextInt();
        b = input.nextInt();

        int ans = 2000000000;
        int X , Y;
        int xn , yn;

        for(int k = 0 ; k < 4 ; k++) {
            X = (n - 1) * di[k] + 1;
            Y = (m - 1) * dj[k] + 1;
            xn = Math.abs(X - i);
            yn = Math.abs(Y - j);
            if(xn % a == 0 && yn % b == 0){
                if((xn / a) % 2 == (yn / b) % 2){
                    if((xn / a) > (yn / b) && (Y + b <= m ||  Y - b >= 1)){
                        ans = Math.min(ans , (xn / a));
                    }else if((xn / a) < (yn / b) && (X + a <= n ||  X - a >= 1)){
                        ans = Math.min(ans , (yn / b));
                    }else if((xn / a) == (yn / b)){
                        ans = Math.min(ans , (xn / a));
                    }
                }
            }
        }

        if(ans != 2000000000){
            System.out.println(ans);
        }else{
            System.out.println("Poor Inna and pony!");
        }

    }
}
