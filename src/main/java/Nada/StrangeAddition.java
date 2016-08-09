package Nada;
import java.util.*;
import java.util.Scanner;

/**
 * Created by Nada on 8/1/16.
 */
public class StrangeAddition {

        public static void main(String[] args) {
            Scanner reader = new Scanner(System.in);
            int k = reader.nextInt();
            int unit = -1;
            boolean t1=false,t2=false;
            List hs = new ArrayList();
            for(int i=0; i<k; i++){
                int v = reader.nextInt();
                if(v==0||v==100){
                    hs.add(v);
                } else if(t1==false && v%10==0){
                    t1=true;
                    hs.add(v);
                } else if(t2==false && v<10){
                    t2=true;
                    hs.add(v);
                } else{
                    unit=v;
                }
            }
            if(unit!=-1 && t1==false && t2==false){
                hs.add(unit);
            }
            System.out.println(hs.size());
            for(int i=0; i<hs.size(); i++) System.out.print(hs.get(i)+" ");
        }
}
