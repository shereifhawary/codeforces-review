package mustafa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mustafa on 7/27/2016.
 */
public class A305 {
    public  static Boolean know_If_There_Is_Zero(int x){
        if(x==0) {
            return true;
        }
        while (x>0){
            if(x%10==0){
                return true;
            }
            x/=10;
        }
        return false;
    }
    public  static Boolean Match(int x,int y){
        int minn=x;
        if(y<x){
            minn=x;
        }
        while(minn!=0){
            if(x%10!=0&&y%10!=0){
                return  false;
            }
            x/=10;
            y/=10;
            minn/=10;
        }
        return true;
    }
    public static void main(String... args) {
        int k, x;
        Scanner reader = new Scanner(System.in);
        k = reader.nextInt();
        List<Integer> number_Without_Zeros = new ArrayList<Integer>();
        List<Integer> number_With_Zeros = new ArrayList<Integer>();
        for (int i = 0; i < k; i++){
            x= reader.nextInt();
            if(know_If_There_Is_Zero(x)==true) {
                number_With_Zeros.add(x);
            }
            else{
                number_Without_Zeros.add(x);
            }
        }
        int  sum=0;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int i =0;i<number_With_Zeros.size();i++){
            if(Match(sum,number_With_Zeros.get(i).intValue())==true){
                output.add(number_With_Zeros.get(i));
                sum+=number_With_Zeros.get(i);
            }
        }
        for(int i =0;i<number_Without_Zeros.size();i++){
            if(Match(sum,number_Without_Zeros.get(i))==true){
                output.add(number_Without_Zeros.get(i));
                sum+=number_Without_Zeros.get(i);
            }
        }
        System.out.println(""+output.size());
        for(int i =0;i<output.size();i++){
            System.out.print(output.get(i)+" ");
        }
        System.out.println();
    }
}
